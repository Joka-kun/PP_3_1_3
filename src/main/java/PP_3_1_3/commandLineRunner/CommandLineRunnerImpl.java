package PP_3_1_3.commandLineRunner;

import PP_3_1_3.model.Role;
import PP_3_1_3.model.User;
import PP_3_1_3.repositories.RoleRepository;
import PP_3_1_3.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class CommandLineRunnerImpl implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CommandLineRunnerImpl(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role();
        adminRole.setRole("ROLE_ADMIN");
        adminRole.setId(1);
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRole("ROLE_USER");
        userRole.setId(2);
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUsername("Admin");
        adminUser.setPassword(passwordEncoder.encode("Admin"));
        adminUser.setName("Admin");
        adminUser.setLastName("Admin");
        adminUser.setAge(37);
        adminUser.setEmail("admin@admin.ru");
        adminUser.setRoles(List.of(roleRepository.getById(1), roleRepository.getById(2)));
        userRepository.save(adminUser);

        User userUser = new User();
        userUser.setUsername("User");
        userUser.setPassword(passwordEncoder.encode("User"));
        userUser.setName("User");
        userUser.setLastName("User");
        userUser.setAge(18);
        userUser.setEmail("user@user.ru");
        userUser.setRoles(List.of(roleRepository.getById(2)));
        userRepository.save(userUser);
    }
}
