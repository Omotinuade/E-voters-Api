package com.evoters.dtos.request;
import lombok.Data;

@Data
public class PasswordResetRequest {
    private String emailAddress;
    private String newPassword;
    private String confirmNewPassword;
}
