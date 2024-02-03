package gdsc.nanuming.jwt.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import lombok.Getter;

@Getter
@RedisHash(value = "refreshToken")
public class RefreshToken {

	@Id
	private String refreshToken;

	private Long memberId;

	@TimeToLive
	private Long tokenPeriod;

	public RefreshToken(final String refreshToken, final Long memberId, final Long tokenPeriod) {
		this.refreshToken = refreshToken;
		this.memberId = memberId;
		this.tokenPeriod = tokenPeriod;
	}
}