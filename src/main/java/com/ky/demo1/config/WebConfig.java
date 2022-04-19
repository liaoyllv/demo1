package com.ky.demo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    @Description("Thymeleaf template resolver serving HTML 5")
    public ClassLoaderTemplateResolver templateResolver() {
        // 这个 bean 定义了一个模板解析器。 模板解析器将模板解析为TemplateResolution对象，
        // 其中包含其他信息，例如模板模式，缓存，模板的前缀和后缀。 ClassLoaderTemplateResolver用于加载位于类路径上的模板。
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        // 将模板目录设置为templates。 使用ClassLoaderTemplateResolver时，前缀中没有classpath:。
        templateResolver.setPrefix("templates/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");

        return templateResolver;
    }

    @Bean
    @Description("Thymeleaf template engine with Spring integration")
    public SpringTemplateEngine templateEngine() {
        // 创建具有 Spring 集成的 Thymeleaf 模板引擎。

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());

        return templateEngine;
    }

    @Bean
    @Description("Thymeleaf view resolver")
    public ViewResolver viewResolver() {
        // 配置一个创建ThymeleafViewResolver的 bean。 视图解析器负责获取特定操作和语言环境的 View 对象。
        // 然后将视图对象渲染为 HTML 文件。

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");

        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 用addViewController()方法定义一个自动控制器。
        registry.addViewController("/").setViewName("index");
    }

}
