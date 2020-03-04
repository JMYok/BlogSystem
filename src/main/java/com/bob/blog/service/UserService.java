package com.bob.blog.service;

import com.bob.blog.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User CheckUser(String username,String password);
}
