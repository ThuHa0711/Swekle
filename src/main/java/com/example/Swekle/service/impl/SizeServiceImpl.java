package com.example.Swekle.service.impl;

import com.example.Swekle.model.Size;
import com.example.Swekle.repository.SizeRepo;
import com.example.Swekle.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    SizeRepo sizeRepo;

    @Override
    public List<Size> getListSize(){
        return sizeRepo.getSizeInterface();
    }

    @Override
    public List<Size> searchSize(String search) {
        return sizeRepo.findBySearch(search);
    }

    @Override
    public void addSize(Size size){
        sizeRepo.save(size);
    }

    @Override
    public Size viewUpdateSize(Integer id){
        return sizeRepo.findById(id).get();
    }

    @Override
    public void updateSize(Size size){
        sizeRepo.save(size);
    }

    @Override
    public void deleteSize(Integer id){
        sizeRepo.deleteById(id);
    }
}
