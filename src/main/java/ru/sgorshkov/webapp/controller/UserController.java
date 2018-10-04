package ru.sgorshkov.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sgorshkov.webapp.model.ResponseObject;
import ru.sgorshkov.webapp.service.UserService;

import java.util.Map;

@Controller
public class UserController {

    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String DEFAULT_PAGE = "0";
    private static final String DEFAULT_SORT_FIELD = "first_name";
    private static final String DEFAULT_SORT_DIR = "desc";

    @Autowired
    UserService userService;

    @GetMapping("user")
    public String showUserPage(Model model){
        return "user";
    }

    @GetMapping("user/list")
    @ResponseBody
    public ResponseObject findAllUserByParam(@RequestParam Map<String, String> request){

        int page = Integer.parseInt(request.getOrDefault("page", DEFAULT_PAGE));
        int pageSize = Integer.parseInt(request.getOrDefault("pageSize", DEFAULT_PAGE_SIZE));
        String sortField = request.getOrDefault("sort[0][field]", DEFAULT_SORT_FIELD);
        String sortDir = request.getOrDefault("sort[0][dir]", DEFAULT_SORT_DIR);
        if(sortField.equals("name")){ sortField = "lastName";}

        return userService.findAll(page, pageSize, sortField, sortDir);
    }

}
