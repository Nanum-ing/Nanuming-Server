package gdsc.nanuming.security.jwt.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import gdsc.nanuming.security.jwt.dto.GeneratedToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtUtil {

	@Value("sm://JWT_ACCESS_TOKEN_PERIOD")
	private String accessTokenPeriod;

	@Value("sm://JWT_REFRESH_TOKEN_PERIOD")
	private String refreshTokenPeriod;

	private SecretKey secretKey;

	@PostConstruct
	protected void init() {
		secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}

	public GeneratedToken generateToken(String email, String role) {

		String accessToken = generateAccessToken(email, role);
		String refreshToken = generateRefreshToken(email, role);

		return new GeneratedToken();
		// TODO: need additional work here
	}

	private String generateAccessToken(String email, String role) {
		Claims claims = Jwts.claims().setSubject(email);
		claims.put("role", role);

		Date now = new Date();

		return
			Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + Long.parseLong(accessTokenPeriod)))
				.signWith(secretKey)
				.compact();
	}

	private String generateRefreshToken(String email, String role) {
		Claims claims = Jwts.claims().setSubject(email);
		claims.put("role", role);

		Date now = new Date();

		return
			Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + Long.parseLong(refreshTokenPeriod)))
				.signWith(secretKey)
				.compact();
	}

	public boolean verifyToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parserBuilder()
				.setSigningKey(secretKey)
				.build().parseClaimsJws(token);

			return claims.getBody()
				.getExpiration()
				.after(new Date());
		} catch (Exception e) {
			return false;
		}
	}
}