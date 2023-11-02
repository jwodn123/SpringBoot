package com.jjw.springboot.test.web.dto;

import com.jjw.SpringBoot.test.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        //assertThat -> assertj라는 테스트 검증 라이브러리의 검증 메소드, 검증하고 싶은 대상은 인자로 받는다.
        //isEqualTo -> assertj의 동등 비교 메소드, assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
