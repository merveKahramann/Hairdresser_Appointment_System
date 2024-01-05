package com.example.kuaforrandevusistemi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PersonelDto {
    private Long kuafor_id;
    private String kuafor_ad;
    private String kuafor_soyad;
    private String kuafor_tel_no;
    private String alan_ad;
    private Long alan_id;
    private String tarih;
    private Long seans;
}