package com.example.Swekle.service.impl;

import com.example.Swekle.model.HoaDon;
import com.example.Swekle.repository.HoaDonRepo;
import com.example.Swekle.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepo hoaDonRepo;

    @Override
    public List<HoaDon> getListHD(){
        return hoaDonRepo.getHoaDonInterface();
    }

}
