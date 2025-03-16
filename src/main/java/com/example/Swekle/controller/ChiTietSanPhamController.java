package com.example.Swekle.controller;

import com.example.Swekle.model.ChiTietSanPham;
import com.example.Swekle.service.ChatLieuService;
import com.example.Swekle.service.ChiTietSanPhamService;
import com.example.Swekle.service.MauSacService;
import com.example.Swekle.service.SanPhamService;
import com.example.Swekle.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String hienThi(Model model, @ModelAttribute("ctsp")ChiTietSanPham chiTietSanPham){
        model.addAttribute("listCTSP", chiTietSanPhamService.getListCTSP());
        return "/chi-tiet-san-pham.html";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id){
       ChiTietSanPham chiTietSanPham = chiTietSanPhamService.viewUpdateCTSP(id);
        model.addAttribute("listSP", sanPhamService.getListSP());
//        model.addAttribute("listMS", mauSacService.getListMS());
        model.addAttribute("listCL", chatLieuService.getListCL());
        model.addAttribute("listSize", sizeService.getListSize());

        return "/update-ctsp.html";
    }
}
