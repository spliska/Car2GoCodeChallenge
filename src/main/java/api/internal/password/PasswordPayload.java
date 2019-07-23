package api.internal.password;

public class PasswordPayload {
   private String password;
   private String passwordOld;

    public PasswordPayload(String password, String passwordOld) {
        this.password = password;
        this.passwordOld = passwordOld;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordOld() {
        return passwordOld;
    }
}
