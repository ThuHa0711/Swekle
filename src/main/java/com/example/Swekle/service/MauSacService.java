package com.example.Swekle.service;

import com.example.Swekle.model.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MauSacService {

    Page<MauSac> getListMS(int page, int size);

    MauSac viewUpdateMS(Integer id);

    void updateMS(MauSac mauSac);

    void addMS(MauSac mauSac);

    void deleteMS(Integer id);

    Page<MauSac> searchMS(String search, int page, int size);
}
