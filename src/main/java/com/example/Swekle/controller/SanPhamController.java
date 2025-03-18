package com.example.Swekle.controller;

import com.example.Swekle.model.DanhMuc;
import com.example.Swekle.model.SanPham;
import com.example.Swekle.service.DanhMucService;
import com.example.Swekle.service.SanPhamService;
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
@RequestMapping("/swekle/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    DanhMucService danhMucService;

    @GetMapping("/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model, @ModelAttribute("sanPham") SanPham sanPham){
        Page<SanPham> sanPhamPage = sanPhamService.getListSP(page, 5);
        model.addAttribute("sanPhamPage", sanPhamPage);
        return "/san-pham.html";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@RequestParam(defaultValue = "0") int page, Model model, @PathVariable("id") Integer id){
        SanPham sanPham = sanPhamService.viewUpdateSP(id);
        model.addAttribute("sanPham", sanPham);
        Page<DanhMuc> danhMucPage = danhMucService.getListDM(page, 5);
        model.addAttribute("danhMucPage", danhMucPage);
        return "/update-san-pham.html";
    }


}
