package com.example.controller;

import com.example.dto.AccountDTO;
import com.example.enums.AccountType;
import com.example.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

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

    @GetMapping("/create-form")
    public String getCreateForm(Model model) {
        // We need to provide empty Account object to the view
        model.addAttribute("account", new AccountDTO());
//        // We need to provide accountType enum to the view
//        model.addAttribute("accountTypes", AccountType.values());

        return "/account/create-account";
    }

    @PostMapping("/create")
    public String createAccount(@Valid @ModelAttribute AccountDTO accountDTO, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("accountTypes", AccountType.values());

            return "/account/create-account";
        }

        accountService.createNewAccount(accountDTO.getBalance(), new Date(), accountDTO.getAccountType(), accountDTO.getUserId());

        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable UUID id) {
        accountService.deleteAccount(id);

        return "redirect:/index";
    }

    @GetMapping("/activate/{id}")
    public String activateAccount(@PathVariable UUID id) {
        accountService.activateAccount(id);

        return "redirect:/index";
    }
}

