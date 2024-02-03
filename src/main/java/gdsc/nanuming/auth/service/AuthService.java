package gdsc.nanuming.auth.service;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;

import gdsc.nanuming.jwt.repository.RefreshTokenRepository;
import gdsc.nanuming.jwt.util.JwtUtil;
import gdsc.nanuming.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final MemberRepository memberRepository;
	private final JwtUtil jwtUtil;
	private final RefreshTokenRepository refreshTokenRepository;

}
