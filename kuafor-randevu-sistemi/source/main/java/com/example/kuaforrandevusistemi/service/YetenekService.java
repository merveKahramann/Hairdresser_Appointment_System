package com.example.kuaforrandevusistemi.service;

import com.example.kuaforrandevusistemi.dto.YetenekDto;
import java.util.List;

public interface YetenekService {
    YetenekDto yetenekYarat(YetenekDto yetenekDto);
    YetenekDto idIleGetir(Long yetenekId);

    List<YetenekDto> tumYetenekleriGetir();

    YetenekDto yetenekGuncelle(Long yetenekId, YetenekDto guncellenenYetenek);

    void yetenekSil(Long yetenekId);
}