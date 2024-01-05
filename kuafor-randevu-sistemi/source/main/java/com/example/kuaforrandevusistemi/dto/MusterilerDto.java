package com.example.kuaforrandevusistemi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MusterilerDto {
    private Long musteri_id;
    private String musteri_ad;
    private String musteri_soyad;
    private String musteri_tel_no;
    private String musteri_kullanici_ad;
    private Long musteri_sifre;
    private String musteri_tarih;
    private Long musteri_seans;
}