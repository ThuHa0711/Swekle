package com.example.Swekle.repository;

import com.example.Swekle.model.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatLieuRepo extends JpaRepository<ChatLieu, Integer> {
    @Query(value = "SELECT [id]\n" +
            "      ,[ma_chat_lieu]\n" +
            "      ,[ten_chat_lieu]\n" +
            "      ,[trang_thai]\n" +
            "  FROM [dbo].[chat_lieu]", nativeQuery = true)
    Page<ChatLieu> getChatLieuWithPagination(Pageable pageable);

    @Query("SELECT m FROM ChatLieu m WHERE " +
            "LOWER(m.maCL) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(m.tenCL) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<ChatLieu> findBySearch(@Param("search") String search, Pageable pageable);
}
