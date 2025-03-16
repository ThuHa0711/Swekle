package com.example.Swekle.repository;

import com.example.Swekle.model.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChucVuRepo extends JpaRepository<ChucVu, Integer> {
    @Query(value = "SELECT [id]\n" +
            "      ,[ma_chuc_vu]\n" +
            "      ,[ten_chuc_vu]\n" +
            "      ,[trang_thai]\n" +
            "  FROM [dbo].[chuc_vu]", nativeQuery = true)
    List<ChucVu> getChucVuInterface();
}
