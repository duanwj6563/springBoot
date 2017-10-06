package com.sunland.springBoot;

import com.sunland.domain.User;
import com.sunland.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {

    }

    @Test
    public void hello() {
      User u= userRepository.findByUserName("sa");
      System.out.println(u.toString());
    }
}
