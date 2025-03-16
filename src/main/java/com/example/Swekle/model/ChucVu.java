package com.example.Swekle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chuc_vu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_chuc_vu", nullable = false, unique = true)
    @NotBlank(message = "Mã chức vụ không được để trống")
    private String maChucVu;

    @Column(name = "ten_chuc_vu")
    @NotBlank(message = "Tên chức vụ không được để trống")
    private String tenChucVu;

    @Column(name = "trang_thai")
    @NotNull(message = "Trạng thái không được để trống")
    private Boolean trangThai;

}
