package com.example.Swekle.repository;

import com.example.Swekle.model.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSanPham, Integer> {
    @Query(value = "Select ctsp.id, ctsp.id_sp, sp.ten_san_pham, ctsp.id_mau_sac, ms.ten_mau, ctsp.id_chat_lieu, cl.ten_chat_lieu, ctsp.id_size, s.ten_size, ctsp.gia_ban, ctsp.so_luong_ton," +
            "ctsp.trang_thai from ctsp" +
            " inner join san_pham sp on ctsp.id_sp = sp.id" +
            " inner join mau_sac ms on ctsp.id_mau_sac = ms.id" +
            " inner join chat_lieu cl on ctsp.id_chat_lieu = cl.id" +
            " inner join size s on ctsp.id_size = s.id", nativeQuery = true)
    List<ChiTietSanPham> getCTSPInterface();
}
