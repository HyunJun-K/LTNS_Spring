package com.ltns.rest_area.validator.user;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ltns.rest_area.domain.user.UserDTO;

@Component
public class UserValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserDTO user = (UserDTO) target;
		String message = user.getMessage();

		if (message.equals("insertUser")) {
			String regex = null;

			String username = user.getUm_username().trim();
			if (username != null && !username.equals("")) {
				regex = "[a-zA-Z0-9]{1,}@[a-zA-Z]{1,}.[a-zA-Z]{1,}";
				if (!inspect(regex, username)) {
					errors.rejectValue("um_username", "validation", new String[] { username }, "아이디(이메일) 형식이 아닙니다.");
				}
			} else {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "um_username", "empty");
			}

			String password = user.getUm_password().trim();
			if (password != null && !password.equals("")) {
				regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()\\-_=+?])[A-Za-z0-9!@#$%^&*()\\-_=+?]{8,20}";
				if (!inspect(regex, password)) {
					errors.rejectValue("um_password", "validation", new String[] { password },
							"비밀번호는 특수문자, 대문자, 소문자, 숫자를 포함한 8 ~ 20 자리입니다.");
				} else {
					String passwordCheck = user.getPasswordCheck();
					if (!password.equals(passwordCheck))
						errors.rejectValue("passwordCheck", "validation", new String[] { passwordCheck },
								"비밀번호가 서로 다릅니다.");
				}
			} else {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "um_password", "empty");
			}

			String nickname = user.getUm_nickname().trim();
			if (nickname != null && !nickname.equals("")) {
				regex = "[a-zA-Z0-9ㄱ-힣]{2,8}";
				if (!inspect(regex, nickname))
					errors.rejectValue("um_nickname", "validation", new String[] { nickname }, "허용하는 범위에 맞지 않습니다.");
			} else {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "um_nickname", "empty");
			}
		} else if (message.equals("findByUid")) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "um_uid", "empty");
		} else if (message.equals("findByUsername")) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "um_username", "empty");
		} else if (message.equals("findByNickname")) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "um_nickname", "empty");
		} else {
			return;
		}

	}

	boolean inspect(String regex, String input) {
		if (Pattern.matches(regex, input))
			return true;
		return false;
	}
}
