package api.internal.api;

import java.util.List;

public class AuthenticationContainer {
    private List cookies;
    private String bearerToken;
    private String csrfToken;

    public AuthenticationContainer(String bearerToken, List cookies) {
        this.cookies = cookies;
        this.bearerToken = bearerToken;
    }

    public AuthenticationContainer(String bearerToken, List cookies, String csrfToken) {
        this(bearerToken, cookies);
        this.csrfToken = csrfToken;
    }

    public List getCookies() {
        return cookies;
    }

    public String getBearerToken() {
        return bearerToken;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public void setCsrfToken(String csrfToken) {
        if (!"unknown".equalsIgnoreCase(csrfToken))
            this.csrfToken = csrfToken;
    }
}
