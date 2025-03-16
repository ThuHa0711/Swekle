package com.example.Swekle.controller;

import com.example.Swekle.model.NhanVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/swekle")
public class TrangChuController {
    @GetMapping("/trang-chu")
    public String trangChu(Model model){
        return "/index.html";
    }

}
