package br.edu.iff.PackNow.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/pagina1","morador/listar","/encomenda/listar","endereco/listar").permitAll()
				.requestMatchers("/cargo/**", "/h2-console/**", "/swagger-ui/**")
				.hasRole("FuncionarioNv1")
				.requestMatchers("static/**").permitAll()
				.anyRequest().authenticated())
				.formLogin((form) -> form.permitAll())
				.logout((logout) -> logout.logoutSuccessUrl("/").permitAll());
		return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/register");
    }
    


}
