// package com.example.VotingSystem.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Description;
// import org.springframework.web.servlet.ViewResolver;
// import
// org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import
// org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import org.springframework.web.servlet.view.InternalResourceViewResolver;
// import org.springframework.web.servlet.view.JstlView;
// import org.springframework.web.servlet.view.UrlBasedViewResolver;
// import org.thymeleaf.spring6.SpringTemplateEngine;
// import org.thymeleaf.spring6.view.ThymeleafViewResolver;
// import org.thymeleaf.templatemode.TemplateMode;
// import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
// import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

// import jakarta.servlet.ServletContext;

// // @Configuration
// // public class WebConfig implements WebMvcConfigurer {

// // @Bean
// // public ServletContextTemplateResolver templateResolver() {
// // ServletContext templateResolver = new ServletContext();
// // ServletContextTemplateResolver resolver = new
// ServletContextTemplateResolver();
// // resolver.setPrefix("/WEB-INF/views/");
// // resolver.setSuffix(".html");
// // resolver.setTemplateMode(TemplateMode.HTML);
// // return resolver;
// // }

// // @Bean
// // public SpringTemplateEngine templateEngine() {
// // SpringTemplateEngine engine = new SpringTemplateEngine();
// // engine.setTemplateResolver(templateResolver());
// // return engine;
// // }

// // @Bean
// // public ThymeleafViewResolver viewResolver() {
// // ThymeleafViewResolver resolver = new ThymeleafViewResolver();
// // resolver.setTemplateEngine(templateEngine());
// // return resolver;
// // }

// // @Override
// // public void configureViewResolvers(ViewResolverRegistry registry) {
// // registry.viewResolver(viewResolver());
// // }

// // @Override
// // public void addResourceHandlers(ResourceHandlerRegistry registry) {
// // registry
// // .addResourceHandler("/css/**", "/js/**", "/images/**")
// // .addResourceLocations("/WEB-INF/static/css/", "/WEB-INF/static/js/",
// "/WEB-INF/static/images/");
// // }
// // }

// @Configuration
// public class WebConfig implements WebMvcConfigurer {

// @Bean
// @Description("Thymeleaf template resolver serving HTML 5")
// public ClassLoaderTemplateResolver templateResolver() {

// ClassLoaderTemplateResolver templateResolver = new
// ClassLoaderTemplateResolver();

// templateResolver.setPrefix("templates/");
// templateResolver.setCacheable(false);
// templateResolver.setSuffix(".html");
// templateResolver.setTemplateMode("HTML5");
// templateResolver.setCharacterEncoding("UTF-8");

// return templateResolver;
// }

// @Bean
// @Description("Thymeleaf template engine with Spring integration")
// public SpringTemplateEngine templateEngine() {

// SpringTemplateEngine templateEngine = new SpringTemplateEngine();
// templateEngine.setTemplateResolver(templateResolver());

// return templateEngine;
// }

// @Bean
// @Description("Thymeleaf view resolver")
// public ViewResolver viewResolver() {

// ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

// viewResolver.setTemplateEngine(templateEngine());
// viewResolver.setCharacterEncoding("UTF-8");

// return viewResolver;
// }

// /*
// * @Override
// * public void addViewControllers(ViewControllerRegistry registry) {
// * registry.addViewController("/").setViewName("index");
// * }
// */
// }