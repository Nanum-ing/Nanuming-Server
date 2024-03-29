package gdsc.nanuming.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import gdsc.nanuming.security.entrypoint.JwtAuthenticationEntryPoint;
import gdsc.nanuming.security.filter.JwtFilter;
import gdsc.nanuming.security.handler.JwtAccessDeniedHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
	private final JwtFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// CSRF
		http.csrf(AbstractHttpConfigurer::disable);

		// CORS
		http.cors(Customizer.withDefaults());

		http.sessionManagement(
			sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.formLogin(AbstractHttpConfigurer::disable);

		http.httpBasic(AbstractHttpConfigurer::disable);

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		http.exceptionHandling((exceptionHandling) -> exceptionHandling
			.authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.accessDeniedHandler(jwtAccessDeniedHandler));

		http.authorizeHttpRequests(httpRequests -> httpRequests
			.requestMatchers("/api/auth/**").permitAll()
			.requestMatchers("/openapi/**").permitAll()
			.anyRequest().authenticated()
		);

		return http.build();

	}

	@Bean
	public HttpTransport httpTransport() {
		return new NetHttpTransport();
	}

	@Bean
	public GsonFactory gsonFactory() {
		return new GsonFactory();
	}

}
