package com.example.Swekle.service;

import com.example.Swekle.model.ChatLieu;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getListCL();

    void addCL(ChatLieu chatLieu);

    ChatLieu viewUpdateCL(Integer id);

    void updateCL(ChatLieu chatLieu);

    void deleteCL(Integer id);

//    List<ChatLieu> searchCL(Integer id, String maCL, String tenCL, Boolean trangThai);
}
