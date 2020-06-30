package cn.fv.controller;

import cn.fv.pojo.User;
import cn.fv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public User getById(@PathVariable("id") Integer id){
        return userService.getById(id);
    }
    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll(){
        return userService.getAll();
    }
    @RequestMapping("/add")
    public void insert(){
        User user = new User();
        user.setName("rose");
        user.setAge(33);
        userService.add(user);
    }
}
