package com.example.Swekle.controller;

import com.example.Swekle.model.DanhMuc;
import com.example.Swekle.service.DanhMucService;
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
@RequestMapping("/swekle/danh-muc")
public class DanhMucController {
    @Autowired
    DanhMucService danhMucService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("danhMuc") DanhMuc danhMuc){
        model.addAttribute("listDanhMuc", danhMucService.getListDM());
        return "/danh-muc.html";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("danhMuc") DanhMuc danhMuc, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("listDanhMuc", danhMucService.getListDM());
            return "/danh-muc.html";
        }
        danhMucService.addDM(danhMuc);
        return "redirect:/swekle/danh-muc/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id){
        DanhMuc danhMuc = danhMucService.viewUpdateDM(id);
        model.addAttribute("danhMuc", danhMuc);
        return "/update-danh-muc.html";
    }
}
