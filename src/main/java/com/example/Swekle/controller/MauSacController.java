package com.example.Swekle.controller;

import com.example.Swekle.model.MauSac;
import com.example.Swekle.service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/swekle/mau-sac")
public class MauSacController {
    @Autowired
    MauSacService mauSacService;

    @GetMapping("/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, @ModelAttribute("mauSac") MauSac mauSac, Model model){
//        model.addAttribute("listMauSac", mauSacService.getListMS());
        Page<MauSac> mauSacPage = mauSacService.getListMS(page, 5);
        model.addAttribute("mauSacPage", mauSacPage);
        return "/mau-sac.html";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id){
        MauSac mauSac = mauSacService.viewUpdateMS(id);
        model.addAttribute("mauSac", mauSac);
        return "/update-mau-sac.html";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("mauSac") @Valid MauSac mauSac, Errors errors, @RequestParam(defaultValue = "0") int page, Model model){
        if (errors.hasErrors()){
            Page<MauSac> mauSacPage = mauSacService.getListMS(page, 5);
            model.addAttribute("mauSacPage", mauSacPage);
            model.addAttribute("mauSac", mauSac);
            return "/mau-sac.html";
        }
        mauSacService.addMS(mauSac);
        return "redirect:/swekle/mau-sac/hien-thi?page=" + page;
    }

    @GetMapping("/search")
    public String hienThiMauSac(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(value = "search", required = false) String search,
                                Model model) {
        Page<MauSac> mauSacPage = mauSacService.searchMS(search, page, 5);
        model.addAttribute("mauSacPage", mauSacPage);
        model.addAttribute("search", search);
        model.addAttribute("mauSac", new MauSac());
        return "/mau-sac.html";
    }


}
