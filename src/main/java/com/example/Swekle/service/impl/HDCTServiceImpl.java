package com.example.Swekle.service.impl;

import com.example.Swekle.model.HoaDonChiTiet;
import com.example.Swekle.model.MauSac;
import com.example.Swekle.repository.HDCTRepo;
import com.example.Swekle.service.HDCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HDCTServiceImpl implements HDCTService {
    @Autowired
    HDCTRepo hdctRepo;

    @Override
    public Page<HoaDonChiTiet> getListHDCT(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return hdctRepo.getHoaDonChiTietWithPagination(pageable);
    }

}
