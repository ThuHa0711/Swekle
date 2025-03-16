package com.example.Swekle.service;

import com.example.Swekle.model.Size;

import java.util.List;

public interface SizeService {
    List<Size> getListSize();

    void addSize(Size size);

    Size viewUpdateSize(Integer id);

    void updateSize(Size size);

    void deleteSize(Integer id);
}
