package com.example.Swekle.controller;

import com.example.Swekle.model.ChatLieu;
import com.example.Swekle.service.ChatLieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String hienThi(Model model, @ModelAttribute("chatLieu") ChatLieu chatLieu){
        model.addAttribute("listChatLieu", chatLieuService.getListCL());
        return "/chat-lieu.html";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("listChatLieu", chatLieuService.getListCL());
            return "/chat-lieu.html";
        }
        chatLieuService.addCL(chatLieu);
        return "redirect:/swekle/chat-lieu/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model){
        ChatLieu chatLieu = chatLieuService.viewUpdateCL(id);
        model.addAttribute("chatlieu", chatLieu);
        return "/chat-lieu.html";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("listChatLieu", chatLieuService.getListCL());
            return "/chat-lieu.html";
        }
        chatLieuService.addCL(chatLieu);
        return "redirect:/swekle/chat-lieu/hien-thi";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam(required = false) Integer id,
//                         @RequestParam(required = false) String maCL,
//                         @RequestParam(required = false) String tenCL,
//                         @RequestParam(required = false) Boolean trangThai,
//                         Model model){
//        Boolean trangThaiBool = null;
//        if (trangThai != null) {
//            trangThaiBool = Boolean.valueOf(trangThai); // Chuyển String "true"/"false" thành Boolean
//        }
//        model.addAttribute("listChatLieu", chatLieuService.searchCL(id, maCL, tenCL, trangThai));
//        return "/chat-lieu.html";
//    }
}
