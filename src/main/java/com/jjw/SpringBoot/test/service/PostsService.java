package com.jjw.SpringBoot.test.service;

import com.jjw.SpringBoot.test.domain.posts.Posts;
import com.jjw.SpringBoot.test.domain.posts.PostsRepository;
import com.jjw.SpringBoot.test.web.dto.PostsListResponseDto;
import com.jjw.SpringBoot.test.web.dto.PostsResponseDto;
import com.jjw.SpringBoot.test.web.dto.PostsSaveRequestDto;
import com.jjw.SpringBoot.test.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    //readOnly = true -> 트랜잭션 범위 유지하되 조회 기능만 남겨두어 조회 속도가 개선되기 때문에
    // 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에서 사용하는 것을 추천.
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDese() {
        // 람다식 : .map(PostsListResponseDto::new) => .map(posts -> new PostsListResponseDto(posts))
        // PostRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 변환하는 메소드 입니다.
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

}
