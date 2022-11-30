package PP_3_1_3.service;

import PP_3_1_3.model.Role;
import PP_3_1_3.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    public List<User> getAllUsers();

    public User getUserById(int id);

    public void saveUser(User user);

    public void updateUser(int id, User updatedUser);

    public void deleteUser(int id);

    User findByUsername(String name);


}
