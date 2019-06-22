package cn.wsyjlly.controller;

import cn.wsyjlly.entity.User;
import cn.wsyjlly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wsyjlly
 * @create 2019.06.16 - 17:42
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ModelMap insertUser(String name,String password){
        userService.insertUser(new User()
                .setUsername(name)
                .setPassword(password)
                .setEnable(true)
                .setLocked(false));
        ModelMap map = new ModelMap();
        map.addAttribute("status","OK");
        return map;
    }
    @GetMapping("/getUsers")
    public ModelMap getUsers(Long id){
        System.out.println(id);
        List<User> users = userService.getUsers(new User().setId(id));
        ModelMap map = new ModelMap();
        map.addAttribute("status","OK");
        map.addAttribute("users",users);
        return map;
    }
}
