package JWT_Authentication_2;

public class UserDto {
    private String username;
    private String password;

    public UserDto(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
