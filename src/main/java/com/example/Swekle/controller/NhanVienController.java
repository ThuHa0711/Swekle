package com.example.Swekle.controller;
import com.example.Swekle.model.NhanVien;
import com.example.Swekle.service.ChucVuService;
import com.example.Swekle.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/swekle/nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    ChucVuService chucVuService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("nhanVien")NhanVien nhanVien){
        model.addAttribute("listNhanVien", nhanVienService.getListNV());
        return "/nhan-vien.html";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model){
        NhanVien nhanVien = nhanVienService.viewUpdateNV(id);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("listCV", chucVuService.getListCV());
        return "/update-nhan-vien.html";
    }


}
