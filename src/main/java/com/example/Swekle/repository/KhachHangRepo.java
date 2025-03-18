package com.example.Swekle.repository;

import com.example.Swekle.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, Integer> {
    @Query(value = "SELECT [id]\n" +
            "      ,[ma_kh]\n" +
            "      ,[ho_ten]\n" +
            "      ,[ngay_sinh]\n" +
            "      ,[gioi_tinh]\n" +
            "      ,[email]\n" +
            "      ,[dia_chi]\n" +
            "      ,[sdt]\n" +
            "      ,[trang_thai]\n" +
            "      ,[mat_khau]\n" +
            "  FROM [dbo].[khach_hang]", nativeQuery = true)
    Page<KhachHang> getKhachHangWithPagination(Pageable pageable);
}
