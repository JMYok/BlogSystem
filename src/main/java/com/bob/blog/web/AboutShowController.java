package com.bob.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/6 21:16
 */
@Controller
public class AboutShowController {
    @GetMapping("/about")
    public String about(){
        return "pages/about";
    }
}
