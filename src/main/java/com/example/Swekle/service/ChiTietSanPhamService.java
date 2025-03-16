package com.example.Swekle.service;

import com.example.Swekle.model.ChiTietSanPham;

import java.util.List;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getListCTSP();

    void addCTSP(ChiTietSanPham chiTietSanPham);

    ChiTietSanPham viewUpdateCTSP(Integer id);

    void updateCTSP(ChiTietSanPham chiTietSanPham);

    void deleteCTSP(Integer id);
}
