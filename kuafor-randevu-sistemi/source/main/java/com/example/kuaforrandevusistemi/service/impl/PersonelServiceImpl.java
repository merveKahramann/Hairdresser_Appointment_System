package com.example.kuaforrandevusistemi.service.impl;

import com.example.kuaforrandevusistemi.dto.PersonelDto;
import com.example.kuaforrandevusistemi.entity.Personel;
import com.example.kuaforrandevusistemi.exception.KaynakBulunamadiException;
import com.example.kuaforrandevusistemi.mapper.PersonelMapper;
import com.example.kuaforrandevusistemi.repository.PersonelRepository;
import com.example.kuaforrandevusistemi.service.PersonelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonelServiceImpl implements PersonelService {
    private PersonelRepository personelRepository;
    @Override
    public PersonelDto personelYarat(PersonelDto personelDto) {
        Personel personel = PersonelMapper.mapToPersonel(personelDto);
        Personel kaydedilmisPersonel = personelRepository.save(personel);
        return PersonelMapper.mapToPersonelDto(kaydedilmisPersonel);
    }

    @Override
    public PersonelDto idIleGetir(Long personelId) {
       Personel personel = personelRepository.findById(personelId)
               .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir personel bulunamadi. Id: " + personelId));
       return PersonelMapper.mapToPersonelDto(personel);
    }

    @Override
    public List<PersonelDto> tumPersonelleriGetir() {
        List<Personel> personeller = personelRepository.findAll();
        return personeller.stream().map((personel) -> PersonelMapper.mapToPersonelDto(personel))
                .collect(Collectors.toList());
    }

    @Override
    public PersonelDto personelGuncelle(Long personelId, PersonelDto guncellenenPersonel) {
        Personel personel = personelRepository.findById(personelId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir personel bulunamadi. Id: " + personelId));

        personel.setKuafor_ad(guncellenenPersonel.getKuafor_ad());
        personel.setKuafor_soyad(guncellenenPersonel.getKuafor_soyad());
        personel.setKuafor_tel_no(guncellenenPersonel.getKuafor_tel_no());

        Personel veritabanindaGuncellenmmisPersonel = personelRepository.save(personel);
        return PersonelMapper.mapToPersonelDto(veritabanindaGuncellenmmisPersonel);
    }

    @Override
    public void personelSil(Long personelId) {
        Personel personel = personelRepository.findById(personelId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir personel bulunamadi. Id: " + personelId));

        personelRepository.deleteById(personelId);
    }
}