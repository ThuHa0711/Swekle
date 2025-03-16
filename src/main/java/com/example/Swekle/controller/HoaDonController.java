package com.example.Swekle.controller;

import com.example.Swekle.model.HoaDon;
import com.example.Swekle.repository.HoaDonRepo;
import com.example.Swekle.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    HoaDonRepo hoaDonRepo;

    @Autowired
    KhachHangRepo khachHangRepo;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("hoaDon")HoaDon hoaDon){
        model.addAttribute("listHoaDon", hoaDonRepo.findAll());
        return "/hoa-don.html";
    }
}
