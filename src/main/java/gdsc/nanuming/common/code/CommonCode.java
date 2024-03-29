package gdsc.nanuming.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonCode implements Code {

	RESPONSE_SUCCESS(true, 200, "요청이 완료되었습니다."),
	TOKEN_SUCCESS(true, 200, "토큰이 정상적으로 생성되었습니다."),
	NEED_REGISTER(true, 202, "회원 가입이 필요합니다.");

	private final boolean success;
	private final int status;
	private final String message;

}
