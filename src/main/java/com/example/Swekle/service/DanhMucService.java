package com.example.Swekle.service;

import com.example.Swekle.model.DanhMuc;

import java.util.List;

public interface DanhMucService {
    List<DanhMuc> getListDM();

    void addDM(DanhMuc danhMuc);

    DanhMuc viewUpdateDM(Integer id);

    void updateDM(DanhMuc danhMuc);

    void deleteDM(Integer id);
}
