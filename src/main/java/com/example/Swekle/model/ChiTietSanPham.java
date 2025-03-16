package com.example.Swekle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ctsp")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_sp", referencedColumnName = "id", nullable = false)
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac", referencedColumnName = "id", nullable = false)
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_size", referencedColumnName = "id", nullable = false)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "id_chat_lieu", referencedColumnName = "id", nullable = false)
    private ChatLieu chatLieu;

    @Column(name = "gia_ban")
    private Float giaBan;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @Column(name = "trang_thai")
    private Boolean trangThai;

    public String convertGiaBan(){
        if (giaBan == null){
            return "0";
        }
        else {
            DecimalFormat decimalFormat = new DecimalFormat("#####");
            return decimalFormat.format(giaBan);
        }
    }

}
