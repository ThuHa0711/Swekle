package com.example.Swekle.service.impl;

import com.example.Swekle.model.ChatLieu;
import com.example.Swekle.repository.ChatLieuRepo;
import com.example.Swekle.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    ChatLieuRepo chatLieuRepo;

    @Override
    public List<ChatLieu> getListCL(){
        return chatLieuRepo.getChatLieuInterface();
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

//    @Override
//    public List<ChatLieu> searchCL(Integer id, String maCL, String tenCL, Boolean trangThai){
//        if (id == null && maCL == null && tenCL == null && trangThai == null) {
//            return chatLieuRepo.getChatLieuInterface();
//        }
//        return chatLieuRepo.findByIdContainingAndMaCLContainingAndTenCLContainingAndTrangThaiContaining(id, maCL, tenCL, trangThai);
//    }
}
