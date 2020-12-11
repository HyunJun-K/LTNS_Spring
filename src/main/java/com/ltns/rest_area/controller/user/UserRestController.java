package com.ltns.rest_area.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltns.rest_area.domain.AjaxResult;
import com.ltns.rest_area.domain.user.AjaxList;
import com.ltns.rest_area.domain.user.UserDTO;
import com.ltns.rest_area.service.user.UserService;
import com.ltns.rest_area.validator.user.AuthValidation;
import com.ltns.rest_area.validator.user.UserValidation;

@RestController
public class UserRestController {

	UserService service;


	@Autowired
	public void setService(UserService service) {
		this.service = service;
	}
	
	

	@PostMapping("/auth/user/joinLookup")
	public AjaxResult joinLookup(@Valid UserDTO user, BindingResult bindingResult) {

		String message = user.getMessage();

		AjaxResult result = new AjaxResult();
		result.setStatus("FAIL");
		List<String> msgs = new ArrayList<String>();

		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			errors.forEach(msg -> {
				msgs.add(msg.getDefaultMessage());
			});
			result.setMessage(msgs.get(0));
		} else {
			try {
				List<UserDTO> users = null;
				switch (message) {
				case "checkId":
					users = service.findByUsername(user);
					if (users.size() == 1) {
						result.setCount(users.size());
						result.setMessage(users.get(0).getUm_username() + " 아이디 중복");
					} else {
						result.setStatus("OK");
						result.setMessage("중복되는 아이디가 존재 하지 않습니다.");
					}
					break;
				case "checkNick":
					users = service.findByNickname(user);
					if (users.size() == 1) {
						result.setCount(users.size());
						result.setMessage(users.get(0).getUm_nickname() + " 닉네임 중복");
					} else {
						result.setStatus("OK");
						result.setMessage("중복되는 닉네임이 존재 하지 않습니다.");
					}
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.setMessage("트랜잭션 에러");
			}
		}

		return result;
	}

	@PostMapping("/auth/user/join")
	public AjaxResult join(@Valid UserDTO user, BindingResult bindingResult) {

		AjaxResult result = new AjaxResult();
		result.setStatus("FAIL");
		List<String> msgs = new ArrayList<String>();

		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			errors.forEach(msg -> {
				msgs.add(msg.getDefaultMessage());
			});
			result.setMessage(msgs.get(0));
		} else {
			try {
				int count = service.insertUser(user);
				result.setCount(count);
				result.setStatus("OK");
				result.setMessage("회원가입에 성공했습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				result.setMessage("트랜잭션 오류");
			}
		}

		return result;
	}

	@PostMapping("/member/user/lookUp")
	public AjaxList lookup(@Valid UserDTO user, BindingResult bindingResult) {

		String message = user.getMessage();

		AjaxList result = new AjaxList();
		result.setStatus("FAIL");
		List<String> msgs = new ArrayList<String>();

		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			errors.forEach(msg -> {
				msgs.add(msg.getDefaultMessage());
			});
			result.setMessage(msgs.get(0));
		} else {
		try {
			List<UserDTO> users = null;
			switch (message) {
			case "findByUid":
				users = service.findByUid(user);
				result.setCount(users.size());
				result.setListAll(users);
				result.setStatus("OK");
				result.setMessage("findByUid 트랜잭션 성공");
				break;
			case "findByUsername":
				users = service.findByUsername(user);
				result.setCount(users.size());
				result.setListAll(users);
				result.setStatus("OK");
				result.setMessage("findByUsername 트랜잭션 성공");
				break;
			case "findByNickname":
				users = service.findByNickname(user);
				result.setCount(users.size());
				result.setListAll(users);
				result.setStatus("OK");
				result.setMessage("findByNickname 트랜잭션 성공");
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
			result.setMessage("트랜잭션 오류");
		}
		}

		return result;

	}

	@PutMapping("/member/user/modify")
	public AjaxList modify(@Valid UserDTO user, BindingResult bindingResult) {
		
		String message = user.getMessage();

		AjaxList result = new AjaxList();
		result.setStatus("FAIL");
		List<String> msgs = new ArrayList<String>();

		if(bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			errors.forEach(msg -> {
				msgs.add(msg.getDefaultMessage());
			});
			result.setMessage(msgs.get(0));
		} else {
			try {
				int update = 0;
				List<UserDTO> users = null;
				switch (message) {
				case "updatePw":
					update = service.updatePasswordByUesrname(user);
					if(update == 1) {
						users = service.findByUsername(user);
						result.setCount(users.size());
						result.setListAll(users);
						result.setStatus("OK");
						result.setMessage("updatePw 트랜잭션 성공");
					} 
					break;
				case "updateNick":
					update = service.updateNicknameByUesrname(user);
						if(update == 1) {
							users=service.findByUsername(user);
							result.setCount(users.size());
							result.setListAll(users);
							result.setStatus("OK");
							result.setMessage("updateNick 트랜잭션 성공");
					}
					break;
				case "updatePwAndNick":
					update = service.updateAllByUsername(user);
					if(update == 1) {
						users=service.findByUsername(user);
						result.setCount(users.size());
						result.setListAll(users);
						result.setStatus("OK");
						result.setMessage("updatePwAndNick 트랜잭션 성공");
					}
					break;
			}
			}catch(Exception e) {
				e.printStackTrace();
				result.setMessage("트랜잭션 오류");
			}
		}

		return result;
	}
	
	@DeleteMapping("/member/user/delete")
	public AjaxResult delete(@Valid UserDTO user, BindingResult bindingResult) {

		AjaxResult result = new AjaxResult();
		result.setStatus("FAIL");
		List<String> msgs = new ArrayList<String>();
		
		if(bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			errors.forEach(msg -> {
				msgs.add(msg.getDefaultMessage());
			});
			result.setMessage(msgs.get(0));
		} else {
			try {
				int delete = service.deleteByUesrname(user);
				if(delete == 1) {
					result.setCount(delete);
					result.setStatus("OK");
					result.setMessage("트랜잭션 성공(유저 삭제)");
				}
			}catch(Exception e) {
				e.printStackTrace();
				result.setMessage("트랜잭션 오류");
			}
		}
		
		return result;
	}
	
	@InitBinder
	public void intBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(new UserValidation());
	}
}
