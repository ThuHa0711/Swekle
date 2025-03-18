package com.example.Swekle.controller;

import com.example.Swekle.model.HoaDon;
import com.example.Swekle.model.MauSac;
import com.example.Swekle.service.HoaDonService;
import com.example.Swekle.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/swekle/hoa-don")
public class HoaDonController {
    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    KhachHangService khachHangService;


    @GetMapping("/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model, @ModelAttribute("hoaDon")HoaDon hoaDon){
        Page<HoaDon> hoaDonPage = hoaDonService.getListHD(page, 5);
        model.addAttribute("hoaDonPage", hoaDonPage);
        return "/hoa-don.html";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(value = "search", required = false) String search,
                                Model model) {
        Page<HoaDon> hoaDonPage = hoaDonService.searchHD(search, page, 5);
        model.addAttribute("hoaDonPage", hoaDonPage);
        model.addAttribute("search", search);
        model.addAttribute("hoaDon", new HoaDon());
        return "/hoa-don.html";
    }
}
