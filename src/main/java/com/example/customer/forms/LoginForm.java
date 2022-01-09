package com.example.customer.forms;

import lombok.*;

/**
 * 25.04.2018
 * LoginForm
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    private String email;
    private String password;
}