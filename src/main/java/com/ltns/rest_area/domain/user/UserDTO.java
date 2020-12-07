package com.ltns.rest_area.domain.user;

import lombok.Data;

@Data
public class UserDTO {

    private String username;
    private String password;
    private String realpassword;
    private String nickname;

}
