package ru.sgorshkov.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sgorshkov.webapp.model.ResponseObject;
import ru.sgorshkov.webapp.model.UserModel;
import ru.sgorshkov.webapp.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user")
    public String showUserPage(Model model){
        return "user";
    }

    @GetMapping("user/list")
    @ResponseBody
    public ResponseObject findAllUserByParam(@RequestParam int page,
                                             @RequestParam int pageSize){
        return userService.findAll(page, pageSize);
    }

}
