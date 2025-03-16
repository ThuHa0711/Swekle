package com.example.Swekle.repository;

import com.example.Swekle.model.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac, Integer> {
    @Query(value = "SELECT [id]\n" +
            "      ,[ma_mau]\n" +
            "      ,[ten_mau]\n" +
            "      ,[trang_thai]\n" +
            "  FROM [dbo].[mau_sac]", nativeQuery = true)
    Page<MauSac> getMauSacWithPagination(Pageable pageable);

    @Query("SELECT m FROM MauSac m WHERE " +
            "LOWER(m.maMau) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(m.tenMau) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<MauSac> findBySearch(@Param("search") String search, Pageable pageable);

}
