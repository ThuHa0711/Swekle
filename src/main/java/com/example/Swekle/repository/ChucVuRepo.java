package com.example.Swekle.repository;

import com.example.Swekle.model.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT m FROM ChucVu m WHERE " +
            "LOWER(m.maChucVu) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(m.tenChucVu) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<ChucVu> findBySearch(@Param("search") String search, Pageable pageable);
}
