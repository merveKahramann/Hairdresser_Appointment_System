package com.example.kuaforrandevusistemi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "musteriler")
public class Musteriler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long musteri_id;
    private String musteri_ad;
    private String musteri_soyad;
    private String musteri_tel_no;
    private String musteri_kullanici_ad;
    private Long musteri_sifre;
    private String musteri_tarih;
    private Long musteri_seans;

}