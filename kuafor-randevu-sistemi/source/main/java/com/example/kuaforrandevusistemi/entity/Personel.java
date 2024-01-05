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
@Table(name = "personel")
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private String kuafor_ad;
    private String kuafor_soyad;
    private String kuafor_tel_no;
    private String alan_ad;
    private Long alan_id;
    private String tarih;
    private Long seans;

}