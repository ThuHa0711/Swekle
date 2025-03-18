package com.example.Swekle.service;

import com.example.Swekle.model.ChiTietSanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChiTietSanPhamService {
    Page<ChiTietSanPham> getListCTSP(int page, int size);

    void addCTSP(ChiTietSanPham chiTietSanPham);

    ChiTietSanPham viewUpdateCTSP(Integer id);

    void updateCTSP(ChiTietSanPham chiTietSanPham);

    void deleteCTSP(Integer id);
}
