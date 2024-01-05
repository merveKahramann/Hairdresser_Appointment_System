package com.example.kuaforrandevusistemi.service;

import com.example.kuaforrandevusistemi.dto.RandevularDto;
import java.util.List;

public interface RandevularService {
    RandevularDto randevuYarat(RandevularDto randevularDto);
    RandevularDto idIleGetir(Long randevuId);

    List<RandevularDto> tumRandevulariGetir();

    RandevularDto randevuGuncelle(Long randevuId, RandevularDto guncellenenRandevu);

    void randevuSil(Long randevuId);
}