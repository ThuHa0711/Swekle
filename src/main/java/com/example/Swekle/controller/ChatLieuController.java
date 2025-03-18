package com.example.Swekle.controller;

import com.example.Swekle.model.ChatLieu;
import com.example.Swekle.model.MauSac;
import com.example.Swekle.service.ChatLieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/swekle/chat-lieu")
public class ChatLieuController {
    @Autowired
    ChatLieuService chatLieuService;

    @GetMapping("/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, @ModelAttribute("chatLieu") ChatLieu chatLieu, Model model){
        Page<ChatLieu> chatLieuPage = chatLieuService.getListCL(page, 5);
        model.addAttribute("chatLieuPage", chatLieuPage);
        return "/chat-lieu.html";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu, Errors errors, @RequestParam(defaultValue = "0") int page, Model model){
        if (errors.hasErrors()){
            Page<ChatLieu> chatLieuPage = chatLieuService.getListCL(page, 5);
            model.addAttribute("chatLieuPage", chatLieuPage);
            return "/chat-lieu.html";
        }
        chatLieuService.addCL(chatLieu);
        return "redirect:/swekle/chat-lieu/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model){
        ChatLieu chatLieu = chatLieuService.viewUpdateCL(id);
        model.addAttribute("chatLieu", chatLieu);
        return "/update-chat-lieu.html";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu, Errors errors, @RequestParam(defaultValue = "0") int page, Model model){
        if (errors.hasErrors()){
            Page<ChatLieu> chatLieuPage = chatLieuService.getListCL(page, 5);
            model.addAttribute("chatLieuPage", chatLieuPage);
            return "/chat-lieu.html";
        }
        chatLieuService.updateCL(chatLieu);
        return "redirect:/swekle/chat-lieu/hien-thi";
    }

}
