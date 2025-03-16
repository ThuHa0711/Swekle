package com.example.Swekle.service;

import com.example.Swekle.model.ChucVu;

import java.util.List;

public interface ChucVuService {
    List<ChucVu> getListCV();

    void addCV(ChucVu chucVu);
}
