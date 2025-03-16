package com.example.Swekle.controller;

import com.example.Swekle.model.Size;
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
@RequestMapping("/swekle/size")
public class SizeController {
    @Autowired
    SizeService sizeService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("size")Size size){
        model.addAttribute("listSize", sizeService.getListSize());
        return "/size.html";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id){
        Size size = sizeService.viewUpdateSize(id);
        model.addAttribute("size", size);
        return "/update-size.html";
    }
}
