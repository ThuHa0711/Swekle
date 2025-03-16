package com.example.Swekle.repository;

import com.example.Swekle.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhMucRepo extends JpaRepository<DanhMuc, Integer> {
    @Query(value = "SELECT [id]\n" +
            "      ,[ma_danh_muc]\n" +
            "      ,[ten_danh_muc]\n" +
            "      ,[trang_thai]\n" +
            "  FROM [dbo].[danh_muc]", nativeQuery = true)
    List<DanhMuc> getDanhMucInterface();
}
