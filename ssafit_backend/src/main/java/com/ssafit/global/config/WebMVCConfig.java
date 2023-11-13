package com.ssafit.global.config;

import java.util.List;

import com.ssafit.global.auth.interceptor.JwtArgumentResolver;
import com.ssafit.global.auth.interceptor.JwtInterceptor;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@MapperScan(basePackages = "com.ssafit.*.*.model.mapper")
public class WebMVCConfig implements WebMvcConfigurer {

    private final JwtInterceptor jwtInterceptor;
    private final JwtArgumentResolver jwtArgumentResolver;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/error/**", "/api/**", "/h2-console/**", "/favicon.ico");
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").maxAge(1800);
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(jwtArgumentResolver);
    }
}
