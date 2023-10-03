package com.example.controller;

import com.example.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("accountList", accountService.listAllAccount());
        return "/account/index";
    }
}
