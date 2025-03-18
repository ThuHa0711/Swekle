package com.example.Swekle.service.impl;

import com.example.Swekle.model.ChatLieu;
import com.example.Swekle.repository.ChatLieuRepo;
import com.example.Swekle.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    ChatLieuRepo chatLieuRepo;

    @Override
    public Page<ChatLieu> getListCL(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return chatLieuRepo.getChatLieuWithPagination(pageable);
    }

    @Override
    public Page<ChatLieu> searchCL(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return chatLieuRepo.findBySearch(search, pageable);
    }

    @Override
    public ChatLieu viewUpdateCL(Integer id){
        return chatLieuRepo.findById(id).get();
    }

    @Override
    public void addCL(ChatLieu chatLieu){
        chatLieuRepo.save(chatLieu);
    }

    @Override
    public void updateCL(ChatLieu chatLieu){
        chatLieuRepo.save(chatLieu);
    }

    @Override
    public void deleteCL(Integer id){
        chatLieuRepo.deleteById(id);
    }


}
