package com.task.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.task.manager.app.security.CORSFilter;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.task.*")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public FilterRegistrationBean corsFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();

		registrationBean.setFilter(new CORSFilter());
		registrationBean.addUrlPatterns("/*");

		return registrationBean;
	} 
	
	@Configuration
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter{
        @Override
        public void configure(WebSecurity web) throws Exception {
             web.ignoring().antMatchers("/**");
        }
    }
}
