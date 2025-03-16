package com.example.Swekle.service.impl;

import com.example.Swekle.model.KhachHang;
import com.example.Swekle.repository.KhachHangRepo;
import com.example.Swekle.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepo khachHangRepo;

    @Override
    public List<KhachHang> getListKH(){
        return khachHangRepo.getKhachHangInterface();
    }

    @Override
    public KhachHang viewUpdateKH(Integer id){
        return khachHangRepo.findById(id).get();
    }

    @Override
    public void updateKH(KhachHang khachHang){
        khachHangRepo.save(khachHang);
    }

    @Override
    public void addKH(KhachHang khachHang){
        khachHangRepo.save(khachHang);
    }

    @Override
    public void deleteKH(Integer id){
        khachHangRepo.deleteById(id);
    }

}
