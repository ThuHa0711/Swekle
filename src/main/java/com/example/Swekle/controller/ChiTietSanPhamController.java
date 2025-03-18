package com.example.Swekle.controller;

import com.example.Swekle.model.ChatLieu;
import com.example.Swekle.model.ChiTietSanPham;
import com.example.Swekle.model.HoaDon;
import com.example.Swekle.model.SanPham;
import com.example.Swekle.service.ChatLieuService;
import com.example.Swekle.service.ChiTietSanPhamService;
import com.example.Swekle.service.MauSacService;
import com.example.Swekle.service.SanPhamService;
import com.example.Swekle.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/swekle/chi-tiet-san-pham")
public class ChiTietSanPhamController {
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    MauSacService mauSacService;

    @Autowired
    ChatLieuService chatLieuService;

    @Autowired
    SizeService sizeService;

    @GetMapping("/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, @ModelAttribute("ctsp")ChiTietSanPham chiTietSanPham, Model model){
        Page<ChiTietSanPham> ctspPage = chiTietSanPhamService.getListCTSP(page, 5);
        model.addAttribute("ctspPage", ctspPage);
        return "/chi-tiet-san-pham.html";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@RequestParam(defaultValue = "0") int page, @PathVariable("id") Integer id, Model model){
       ChiTietSanPham chiTietSanPham = chiTietSanPhamService.viewUpdateCTSP(id);
       model.addAttribute("ctsp", chiTietSanPham);
       Page<SanPham> sanPhamPage = sanPhamService.getListSP(page, 5);
       model.addAttribute("sanPhamPage", sanPhamPage);
        Page<ChatLieu> chatLieuPage = chatLieuService.getListCL(page, 5);
        model.addAttribute("chatLieuPage", chatLieuPage);
       model.addAttribute("listSize", sizeService.getListSize());

        return "/update-ctsp.html";
    }
}
