package com.example.Swekle.controller;

import com.example.Swekle.model.HoaDon;
import com.example.Swekle.model.KhachHang;
import com.example.Swekle.service.ChiTietSanPhamService;
import com.example.Swekle.service.HDCTService;
import com.example.Swekle.service.HoaDonService;
import com.example.Swekle.service.KhachHangService;
import com.example.Swekle.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/swekle/ban-hang")
public class BanHangController {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    HDCTService hdctService;

    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("hoaDon")HoaDon hoaDon){
        model.addAttribute("listCTSP", chiTietSanPhamService.getListCTSP());
        model.addAttribute("listHD", hoaDonService.getListHD());
//        model.addAttribute("listHDCT", hdctService.getListHDCT());
        model.addAttribute("listKH", khachHangService.getListKH());
        return "/ban-hang.html";
    }
}
