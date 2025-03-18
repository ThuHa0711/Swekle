package com.example.Swekle.controller;

import com.example.Swekle.model.DanhMuc;
import com.example.Swekle.service.DanhMucService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/swekle/danh-muc")
public class DanhMucController {
    @Autowired
    DanhMucService danhMucService;

    @GetMapping("/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, @ModelAttribute("danhMuc") DanhMuc danhMuc, Model model){
        Page<DanhMuc> danhMucPage = danhMucService.getListDM(page, 5);
        model.addAttribute("danhMucPage", danhMucPage);
        return "/danh-muc.html";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("danhMuc") DanhMuc danhMuc, Errors errors, @RequestParam(defaultValue = "0") int page, Model model){
        if (errors.hasErrors()){
            model.addAttribute("listDanhMuc", danhMucService.getListDM(page, 5));
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
