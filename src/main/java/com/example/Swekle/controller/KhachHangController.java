package com.example.Swekle.controller;

import com.example.Swekle.model.KhachHang;
import com.example.Swekle.service.KhachHangService;
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

@Controller
@RequestMapping("/swekle/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("khachHang")KhachHang khachHang){
        model.addAttribute("listKhachHang", khachHangService.getListKH());
        return "/khach-hang.html";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id){
        KhachHang khachHang = khachHangService.viewUpdateKH(id);
        model.addAttribute("khachHang", khachHang);
        return "/update-khach-hang.html";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("khachHang") KhachHang khachHang, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("listKhachHang", khachHangService.getListKH());
            return "/update-khach-hang.html";
        }
        khachHangService.updateKH(khachHang);
        return "redirect:/swekle/khach-hang/hien-thi";
    }
}
