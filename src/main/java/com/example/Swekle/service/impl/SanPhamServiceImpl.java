package com.example.Swekle.service.impl;

import com.example.Swekle.model.SanPham;
import com.example.Swekle.repository.SanPhamRepo;
import com.example.Swekle.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;

    @Override
    public List<SanPham> getListSP(){
        return sanPhamRepo.getSanPhamInterface();
    }

    @Override
    public void addSP(SanPham sanPham){
        sanPhamRepo.save(sanPham);
    }

    @Override
    public SanPham viewUpdateSP(Integer id){
        return sanPhamRepo.findById(id).get();
    }

    @Override
    public void deleteSP(Integer id){
        sanPhamRepo.deleteById(id);
    }
}
