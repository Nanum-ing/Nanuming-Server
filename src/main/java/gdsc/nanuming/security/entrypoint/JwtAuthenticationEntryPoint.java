package gdsc.nanuming.security.entrypoint;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException, ServletException {

		log.info(">>> JwtAuthenticationEntryPoint commence()");

		// TODO: create custom ErrorResponse here
		// when attempting to access without providing valid credentials -> return 401
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	}
}
