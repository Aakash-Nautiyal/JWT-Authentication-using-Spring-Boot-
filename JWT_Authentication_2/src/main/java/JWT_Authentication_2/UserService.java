package JWT_Authentication_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final String DEFAULT_ROLE = "USER";
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService() {
    }

    public String registerNewUser(String username, String password) {
        if (this.jdbcUserDetailsManager.userExists(username) ) {
            return "User already exists";
        } else {
            UserDetails user = User.withUsername(username).password(this.passwordEncoder.encode(password)).roles(new String[]{"USER"}).build();
            this.jdbcUserDetailsManager.createUser(user);
            return "The user has been added\nusername:" + username + "\n";
        }
    }
}
