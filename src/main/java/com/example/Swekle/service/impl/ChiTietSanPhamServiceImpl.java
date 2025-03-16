package com.example.Swekle.service.impl;

import com.example.Swekle.model.ChiTietSanPham;
import com.example.Swekle.repository.ChiTietSanPhamRepo;
import com.example.Swekle.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;

    @Override
    public List<ChiTietSanPham> getListCTSP(){
        return chiTietSanPhamRepo.getCTSPInterface();
    }

    @Override
    public void addCTSP(ChiTietSanPham chiTietSanPham){
        chiTietSanPhamRepo.save(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham viewUpdateCTSP(Integer id){
        return chiTietSanPhamRepo.findById(id).get();
    }

    @Override
    public void updateCTSP(ChiTietSanPham chiTietSanPham){
        chiTietSanPhamRepo.save(chiTietSanPham);
    }

    @Override
    public void deleteCTSP(Integer id){
        chiTietSanPhamRepo.deleteById(id);
    }
}
