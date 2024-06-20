package generator.Common;

import generator.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration


public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/login")
                .excludePathPatterns("/loginhtml")
                .excludePathPatterns("/register")
                .excludePathPatterns("/error")
                .excludePathPatterns("/backend/**")
               ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将URL路径 /static/** 映射到类路径下的 /static/ 目录
        registry.addResourceHandler("/backend/**")
                .addResourceLocations("classpath:/backend/");
    }
}
