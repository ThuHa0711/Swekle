package com.example.Swekle.service;

import com.example.Swekle.model.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getListSP();

    void addSP(SanPham sanPham);

    SanPham viewUpdateSP(Integer id);

    void deleteSP(Integer id);
}
