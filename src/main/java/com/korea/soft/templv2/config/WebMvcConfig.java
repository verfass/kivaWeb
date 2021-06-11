package com.korea.soft.templv2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korea.soft.templv2.common.ClientIpResolver;
import com.korea.soft.templv2.config.xss.HtmlCharacterEscapes;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Qualifier("beforeActionInterceptor")
    private final HandlerInterceptor beforeActionInterceptor;
    private final ObjectMapper objectMapper;
    private final ClientIpResolver clientIpResolver;

    @Value("${custom.uploadFileDirPath}")
    private String genFileDirPath;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/css/**").excludePathPatterns("/outer/**")
                .excludePathPatterns("/images/**").excludePathPatterns("/js/**").excludePathPatterns("/summernoteImage/**")
                .excludePathPatterns("/favicon.ico").excludePathPatterns("/error");
    }

    // -------------------------- xss 필터 시작 --------------------------------
    // insert 할때는 전부 Controller로처리하고
    // select 할때는 할때는 전부 Controller로처리하고
//    @Bean // Controller 들어오면서 변환되서 들어옴
//    public FilterRegistrationBean getFilterRegistrationBean(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new XssEscapeServletFilter());
//        registrationBean.setOrder(1);
//        registrationBean.addUrlPatterns("/*");    //filter를 거칠 url patterns
//        return registrationBean;
//    }

    // @ResponseBody 데이터로 input: 원본 데이터 => output: 변환된 데이터 나감..
    // !! 단! Dto객체가 아닌 String으로 보낼 경우 MassageConver가 작동하지 않아 변환되지 않는다.
    @Bean
    public MappingJackson2HttpMessageConverter jsonEscapeConverter() {
        ObjectMapper copy = objectMapper.copy();
        copy.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());
        return new MappingJackson2HttpMessageConverter(copy);
    }
    // -------------------------- xss 필터 끝 --------------------------------

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(clientIpResolver);
    }

    //web root가 아닌 외부 경로에 있는 리소스를 url로 불러올 수 있도록 설정
    //현재 localhost:8090/summernoteImage/1234.jpg
    //로 접속하면 C:/summernote_image/1234.jpg 파일을 불러온다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("file:///"+genFileDirPath+"/");
    }



}