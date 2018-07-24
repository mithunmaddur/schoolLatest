package com.school.service;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.service.util.Properties;

@Configuration
@EnableWebMvc
@PropertySource({"classpath:message/message.properties"})
@Order(2)
public class SchoolServiceConfiguration implements WebMvcConfigurer {

  public static final Integer CACHE_SECONDS = 10;
  
 

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localInterceptor());
  }

  @Bean
  public LoggerInterceptor localInterceptor() {
    return new LoggerInterceptor();
  }

 
  @Bean(autowire = Autowire.BY_NAME)
  public Properties transitPropertyConfigurers() {
    Properties ppc = new Properties();
    Resource[] resources =
        new ClassPathResource[] {new ClassPathResource("message/message.properties")};
    ppc.setLocations(resources);
    ppc.setIgnoreUnresolvablePlaceholders(true);
    return ppc;
  }

  @Bean(autowire = Autowire.BY_NAME)
  public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames("classpath:message/message");
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setCacheSeconds(CACHE_SECONDS);
    return messageSource;
  }
  
  @Bean
  public ObjectMapper objectMapper() {
      return Jackson2ObjectMapperBuilder
      .json()
      .featuresToEnable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      .build();
  }

}
