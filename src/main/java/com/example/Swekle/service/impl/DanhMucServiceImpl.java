package com.example.Swekle.service.impl;

import com.example.Swekle.model.DanhMuc;
import com.example.Swekle.repository.DanhMucRepo;
import com.example.Swekle.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    DanhMucRepo danhMucRepo;

    @Override
    public Page<DanhMuc> getListDM(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return danhMucRepo.getDanhMucWithPagination(pageable);
    }

    @Override
    public Page<DanhMuc> searchDM(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return danhMucRepo.findBySearch(search, pageable);
    }

    @Override
    public DanhMuc viewUpdateDM(Integer id){
        return danhMucRepo.findById(id).get();
    }

    @Override
    public void updateDM(DanhMuc danhMuc){
        danhMucRepo.save(danhMuc);
    }

    @Override
    public void addDM(DanhMuc danhMuc){
        danhMucRepo.save(danhMuc);
    }

    @Override
    public void deleteDM(Integer id){
        danhMucRepo.deleteById(id);
    }
}
