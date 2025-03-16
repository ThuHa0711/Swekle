package com.example.Swekle.service.impl;

import com.example.Swekle.model.ChucVu;
import com.example.Swekle.repository.ChucVuRepo;
import com.example.Swekle.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    ChucVuRepo chucVuRepo;

    @Override
    public List<ChucVu> getListCV(){
        return chucVuRepo.getChucVuInterface();
    }

    @Override
    public void addCV(ChucVu chucVu){
        chucVuRepo.save(chucVu);
    }
}
