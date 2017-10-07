/**
 * @describe
 * @author duanwj
 * @since 2017年9月29日 上午11:09:58
 */
package com.sunland.controller;

import com.sunland.domain.User;
import com.sunland.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    /**
     * 查看所有用户信息
     *
     * @return
     */
    @GetMapping
    public List<User> usersList() {
        return userRepository.findAll();
    }

    /**
     * 查看单一用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    public User getUserFindOne(@PathVariable("id") Integer id) {

        return userRepository.findOne(id);

    }

    /**
     * 增加一个用户
     *
     * @param name
     * @param phone
     * @return
     */
    @PostMapping()
    public User userAdd(@RequestParam("name") String name, @RequestParam("phone") Integer phone) {
        User user = new User();
        user.setUserName(name);
        user.setPhone(phone);
        return userRepository.save(user);

    }

    /**
     * 更新一个用户信息
     *
     * @param id
     * @param name
     * @param phone
     * @return
     */
    @PutMapping("/{id:\\d+}")
    public User userUpdate(@PathVariable("id") Integer id, @RequestParam("name") String name,
                           @RequestParam("phone") Integer phone) {
        User user = new User();
        user.setId(id);
        user.setUserName(name);
        user.setPhone(phone);
        return userRepository.save(user);
    }

    /**
     * 删除一个用户
     */
    @DeleteMapping("/{id:\\d+}")
    public void userDelete(@PathVariable("id") Integer id) {
        userRepository.delete(id);
    }
}
