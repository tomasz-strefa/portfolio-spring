package pl.portfolio.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@ComponentScan
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.setAllowedMethods(Arrays.asList("GET","PUT","POST","DELETE"));
        source.registerCorsConfiguration("/**", config);

        http.cors()
                .and().csrf().disable().authorizeRequests().antMatchers("*").permitAll()
                .and().authorizeRequests().antMatchers("/console/**").permitAll()
                .and().headers().frameOptions().sameOrigin();
    }
}
