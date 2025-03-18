package com.example.Swekle.service.impl;

import com.example.Swekle.model.MauSac;
import com.example.Swekle.model.NhanVien;
import com.example.Swekle.repository.NhanVienRepo;
import com.example.Swekle.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService{
    @Autowired
    NhanVienRepo nhanVienRepo;

    @Override
    public Page<NhanVien> getListNV(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return nhanVienRepo.getNhanVienWithPagination(pageable);
    }

    @Override
    public void addNV(NhanVien nhanVien){
        nhanVienRepo.save(nhanVien);
    }

    @Override
    public NhanVien viewUpdateNV(Integer id){
         return nhanVienRepo.findById(id).get();
    }

    @Override
    public void updateNV(NhanVien nhanVien){
        nhanVienRepo.save(nhanVien);
    }

    @Override
    public void deleteNV(Integer id){
        nhanVienRepo.deleteById(id);
    }
}
