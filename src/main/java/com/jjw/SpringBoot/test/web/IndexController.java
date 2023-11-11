package com.jjw.SpringBoot.test.web;

import com.jjw.SpringBoot.test.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    // Model
    // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있습니다.
    // 여기서는 postsService.findAllDesc()로 가져온 결과를 posts를 index.mustache에 전달.
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDese());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
