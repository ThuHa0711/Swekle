package com.example.Swekle.repository;

import com.example.Swekle.model.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatLieuRepo extends JpaRepository<ChatLieu, Integer> {
    @Query(value = "SELECT [id]\n" +
            "      ,[ma_chat_lieu]\n" +
            "      ,[ten_chat_lieu]\n" +
            "      ,[trang_thai]\n" +
            "  FROM [dbo].[chat_lieu]", nativeQuery = true)
    List<ChatLieu> getChatLieuInterface();

//    List<ChatLieu> findByIdContainingAndMaCLContainingAndTenCLContainingAndTrangThaiContaining(Integer id, String maCL, String tenCL, Boolean trangThai);
}
