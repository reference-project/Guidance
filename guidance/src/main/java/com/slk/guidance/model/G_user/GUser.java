package com.slk.guidance.model.G_user;

import lombok.Data;

import javax.persistence.Id;

@Data
public class GUser {
    @Id
    private Integer id;

    /* 用户名 */
    private String username;

    /* 密码 */
    private String password;

}