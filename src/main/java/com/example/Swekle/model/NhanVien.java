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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_nv", nullable = false, unique = true)
    @NotBlank(message = "Mã nhân viên không được để trống")
    private String maNV;

    @Column(name = "ho_ten_nhan_vien")
    @NotBlank(message = "Tên nhân viên không được để trống")
    private String hoTenNV;

    @Column(name = "ngay_sinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "gioi_tinh")
    @NotNull(message = "Giới tính không được để trống")
    private Boolean gioiTinh;

    @Column(name = "email")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @Column(name = "anh")
    @NotBlank(message = "Ảnh không được để trống")
    private String anh;

    @Column(name = "dia_chi")
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;

    @Column(name = "sdt")
    @NotBlank(message = "SDT không được để trống")
    private String sdt;

    @Column(name = "trang_thai")
    @NotNull(message = "Trạng thái không được để trống")
    private Boolean trangThai;

    @Column(name = "mat_khau")
    private String mat_khau;

    @ManyToOne
    @JoinColumn(name = "id_chuc_vu", referencedColumnName = "id")
    private ChucVu chucVu;
}
