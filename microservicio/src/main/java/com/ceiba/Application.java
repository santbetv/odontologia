package com.ceiba;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@ComponentScan({"com.ceiba"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	CorsConfiguration config = new CorsConfiguration();
    	config.setAllowCredentials(true);
    	// config.setAllowedOrigins(Arrays.asList("*"));
    	config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    	config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    	config.setAllowedHeaders(
    			Arrays.asList("X-PINGOTHER", "Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"));
    	source.registerCorsConfiguration("/**", config);// esto es para todas las rutas
    	System.out.println("PETICION CORS2 -->");
    	return source;
    }

    /**
     * Se crear un filtro de cors para registrarlo en Spring, con prioridad alta
     * 
     * @return
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
    	FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
    			new CorsFilter(corsConfigurationSource()));
    	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    	return bean;

    }
}


