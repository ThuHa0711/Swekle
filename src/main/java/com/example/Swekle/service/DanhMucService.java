package com.example.Swekle.service;

import com.example.Swekle.model.DanhMuc;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DanhMucService {
    Page<DanhMuc> getListDM(int page, int size);

    void addDM(DanhMuc danhMuc);

    DanhMuc viewUpdateDM(Integer id);

    void updateDM(DanhMuc danhMuc);

    void deleteDM(Integer id);

    Page<DanhMuc> searchDM(String search, int page, int size);
}
