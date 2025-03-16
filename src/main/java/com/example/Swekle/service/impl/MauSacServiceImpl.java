package com.example.Swekle.service.impl;

import com.example.Swekle.model.MauSac;
import com.example.Swekle.repository.MauSacRepo;
import com.example.Swekle.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepo mauSacRepo;

//    @Override
//    public List<MauSac> getListMS(){
//        return mauSacRepo.getMauSacInterface();
//    }

    @Override
    public Page<MauSac> getListMS(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return mauSacRepo.getMauSacWithPagination(pageable);
    }

    @Override
    public MauSac viewUpdateMS(Integer id){
        return mauSacRepo.findById(id).get();
    }

    @Override
    public void addMS(MauSac mauSac){
        mauSacRepo.save(mauSac);
    }

    @Override
    public void updateMS(MauSac mauSac){
        mauSacRepo.save(mauSac);
    }

    @Override
    public void deleteMS(Integer id){
        mauSacRepo.deleteById(id);
    }

    @Override
    public Page<MauSac> searchMS(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return mauSacRepo.findBySearch(search, pageable);
    }
}
