package com.example.Swekle.service.impl;

import com.example.Swekle.model.DanhMuc;
import com.example.Swekle.repository.DanhMucRepo;
import com.example.Swekle.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    DanhMucRepo danhMucRepo;

    @Override
    public List<DanhMuc> getListDM(){
        return danhMucRepo.getDanhMucInterface();
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
