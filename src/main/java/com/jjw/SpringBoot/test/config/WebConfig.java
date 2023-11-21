package com.jjw.SpringBoot.test.config;

import com.jjw.SpringBoot.test.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }

    // HandlerMethodArgumentResolver는 항상 WebMvcConfigurer의 addArgumentResolvers()을 통해서 추가해야 한다.
    // 다른 HandlerMethodArgumentResolver는가 필요하다면 같은 방식으로 추가해 주면 된다.
}