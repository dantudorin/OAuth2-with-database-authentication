package com.codingfuel.auth.repository;

import com.codingfuel.auth.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DBInit(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User dan = new User("dan", passwordEncoder.encode("dan123"),"USER","ACCESS");
        User admin = new User("admin",passwordEncoder.encode("admin123")," ADMIN","ACCESS_TEST1,ACCESS_TEST2");

        List<User> users = Arrays.asList(dan,admin);

        userRepository.saveAll(users);
    }
}
