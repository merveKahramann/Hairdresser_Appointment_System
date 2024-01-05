package com.example.kuaforrandevusistemi.service;

import com.example.kuaforrandevusistemi.dto.PersonelDto;
import java.util.List;

public interface PersonelService {
    PersonelDto personelYarat(PersonelDto personelDto);
    PersonelDto idIleGetir(Long personelId);

    List<PersonelDto> tumPersonelleriGetir();

    PersonelDto personelGuncelle(Long personelId, PersonelDto guncellenenPersonel);

    void personelSil(Long personelId);
}