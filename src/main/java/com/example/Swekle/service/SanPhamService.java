package com.example.Swekle.service;

import com.example.Swekle.model.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SanPhamService {
    Page<SanPham> getListSP(int page, int size);

    void addSP(SanPham sanPham);

    SanPham viewUpdateSP(Integer id);

    void deleteSP(Integer id);
}
