package io.nikolamicic21.comtrade360javaassignment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration(proxyBeanMethods = false)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String loginProcessingUrl;

    public SecurityConfiguration(@Value("${app.security.login-processing-url}") String loginProcessingUrl) {
        this.loginProcessingUrl = loginProcessingUrl;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/secure/hello").authenticated()
                .mvcMatchers("/admin/**").authenticated()
                .mvcMatchers("/**").permitAll()
                .and()
                .formLogin().loginProcessingUrl(this.loginProcessingUrl);
    }
}
