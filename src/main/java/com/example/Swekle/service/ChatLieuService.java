package com.example.Swekle.service;

import com.example.Swekle.model.ChatLieu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChatLieuService {
    Page<ChatLieu> getListCL(int page, int size);

    void addCL(ChatLieu chatLieu);

    ChatLieu viewUpdateCL(Integer id);

    void updateCL(ChatLieu chatLieu);

    void deleteCL(Integer id);

    Page<ChatLieu> searchCL(String search, int page, int size);
}
