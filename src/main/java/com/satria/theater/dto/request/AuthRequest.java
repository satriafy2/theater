package com.satria.theater.dto.request;

public class AuthRequest {
    private String usernameEmail;
    private String password;

    AuthRequest() {}

    public String getPassword() {
        return password;
    }

    public String getUsernameEmail() {
        return usernameEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsernameEmail(String usernameEmail) {
        this.usernameEmail = usernameEmail;
    }

    public AuthRequest(
        String usernameEmail,
        String password
    ) {
        this.usernameEmail = usernameEmail;
        this.password = password;
    }
}
