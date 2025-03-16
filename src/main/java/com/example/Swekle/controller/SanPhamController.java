package com.example.Swekle.controller;

import com.example.Swekle.model.SanPham;
import com.example.Swekle.service.DanhMucService;
import com.example.Swekle.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/swekle/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    DanhMucService danhMucService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("sanPham")SanPham sanPham){
        model.addAttribute("listSanPham", sanPhamService.getListSP());
        return "/san-pham.html";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id){
        SanPham sanPham = sanPhamService.viewUpdateSP(id);
        model.addAttribute("sanPham", sanPham);
        model.addAttribute("listDM", danhMucService.getListDM());
        return "/update-san-pham.html";
    }
}
