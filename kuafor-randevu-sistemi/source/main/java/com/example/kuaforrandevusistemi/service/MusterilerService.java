package com.example.kuaforrandevusistemi.service;

import com.example.kuaforrandevusistemi.dto.MusterilerDto;
import java.util.List;

public interface MusterilerService {
    MusterilerDto musteriYarat(MusterilerDto musterilerDto);
    MusterilerDto idIleGetir(Long musteriId);

    List<MusterilerDto> tumMusterileriGetir();

    MusterilerDto musteriGuncelle(Long musteriId, MusterilerDto guncellenenMusteri);

    void musteriSil(Long musteriId);
}