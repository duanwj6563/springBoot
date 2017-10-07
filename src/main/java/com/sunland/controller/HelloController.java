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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")//此方法只允许 ROLE_USER 角色访问
    public String index() {
        logger.info("请求到了");
        return "hello";

    }

    @GetMapping("/403")
    public String error() {
        return "403";
    }
}
