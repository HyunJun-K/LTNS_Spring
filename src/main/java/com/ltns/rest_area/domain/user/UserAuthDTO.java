package com.ltns.rest_area.domain.user;

import com.ltns.rest_area.domain.DTO;

import lombok.Data;

@Data
public class UserAuthDTO implements DTO{
	long uid;
	String username;
	String authority;
	String addAuthority;
	String prevAuthority;
	String nextAuthority;
	String message;
}
