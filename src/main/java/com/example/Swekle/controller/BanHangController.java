package com.example.Swekle.controller;

import com.example.Swekle.model.ChiTietSanPham;
import com.example.Swekle.model.HoaDon;
import com.example.Swekle.model.HoaDonChiTiet;
import com.example.Swekle.model.KhachHang;
import com.example.Swekle.service.ChiTietSanPhamService;
import com.example.Swekle.service.HDCTService;
import com.example.Swekle.service.HoaDonService;
import com.example.Swekle.service.KhachHangService;
import com.example.Swekle.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String hienThi(@RequestParam(defaultValue = "0") int page, @ModelAttribute("hoaDon")HoaDon hoaDon, Model model){
        Page<HoaDon> hoaDonPage = hoaDonService.getListHD(page, 5);
        model.addAttribute("hoaDonPage", hoaDonPage);
        Page<HoaDonChiTiet> hdctPage = hdctService.getListHDCT(page, 5);
        model.addAttribute("hdctPage", hdctPage);
        Page<ChiTietSanPham> ctspPage = chiTietSanPhamService.getListCTSP(page, 5);
        model.addAttribute("ctspPage", ctspPage);
        return "/ban-hang.html";
    }
}
