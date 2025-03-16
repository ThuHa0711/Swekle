package com.example.Swekle.service.impl;

import com.example.Swekle.model.HoaDonChiTiet;
import com.example.Swekle.repository.HDCTRepo;
import com.example.Swekle.service.HDCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HDCTServiceImpl implements HDCTService {
    @Autowired
    HDCTRepo hdctRepo;

    @Override
    public List<HoaDonChiTiet> getListHDCT(){
        return hdctRepo.getHoaDonChiTietInterface();
    }

}
