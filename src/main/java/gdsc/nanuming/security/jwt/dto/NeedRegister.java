package gdsc.nanuming.security.jwt.dto;

import lombok.Getter;

@Getter
public class NeedRegister {

	private final boolean needRegister;

	private NeedRegister(boolean needRegister) {
		this.needRegister = needRegister;
	}

}
