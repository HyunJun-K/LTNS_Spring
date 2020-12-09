package com.ltns.rest_area.domain.user;

import lombok.Data;

@Data
public class AuthDTO {

    private String um_username;
    private String authority;
    private String message;
}
