package com.example.Swekle.repository;

import com.example.Swekle.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Integer> {
    @Query(value = "Select sp.id, sp.ma_san_pham, sp.ten_san_pham, sp.anh, sp.mo_ta, sp.trang_thai, sp.id_danh_muc, dm.ten_danh_muc\n" +
            "              from san_pham sp inner join danh_muc dm \n" +
            "              on sp.id_danh_muc = dm.id", nativeQuery = true)
    List<SanPham> getSanPhamInterface();
}
