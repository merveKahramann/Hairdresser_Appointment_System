package com.example.kuaforrandevusistemi.service.impl;

import com.example.kuaforrandevusistemi.dto.YetenekDto;
import com.example.kuaforrandevusistemi.entity.Yetenek;
import com.example.kuaforrandevusistemi.exception.KaynakBulunamadiException;
import com.example.kuaforrandevusistemi.mapper.YetenekMapper;
import com.example.kuaforrandevusistemi.repository.YetenekRepository;
import com.example.kuaforrandevusistemi.service.YetenekService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class YetenekServiceImpl implements YetenekService {
    private YetenekRepository yetenekRepository;
    @Override
    public YetenekDto yetenekYarat(YetenekDto yetenekDto) {
        Yetenek yetenek = YetenekMapper.mapToYetenek(yetenekDto);
        Yetenek kaydedilmisYetenek = yetenekRepository.save(yetenek);
        return YetenekMapper.mapToYetenekDto(kaydedilmisYetenek);
    }

    @Override
    public YetenekDto idIleGetir(Long yetenekId) {
       Yetenek yetenek = yetenekRepository.findById(yetenekId)
               .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir yetenek bulunamadi. Id: " + yetenekId));
       return YetenekMapper.mapToYetenekDto(yetenek);
    }

    @Override
    public List<YetenekDto> tumYetenekleriGetir() {
        List<Yetenek> yetenekler = yetenekRepository.findAll();
        return yetenekler.stream().map((yetenek) -> YetenekMapper.mapToYetenekDto(yetenek))
                .collect(Collectors.toList());
    }

    @Override
    public YetenekDto yetenekGuncelle(Long yetenekId, YetenekDto guncellenenYetenek) {
        Yetenek yetenek = yetenekRepository.findById(yetenekId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir yetenek bulunamadi. Id: " + yetenekId));

        yetenek.setAlan_ad(guncellenenYetenek.getAlan_ad());
        yetenek.setAlan_id(guncellenenYetenek.getAlan_id());
        

        Yetenek veritabanindaGuncellenmmisYetenek = yetenekRepository.save(yetenek);
        return YetenekMapper.mapToYetenekDto(veritabanindaGuncellenmmisYetenek);
    }

    @Override
    public void yetenekSil(Long yetenekId) {
        Yetenek yetenek = yetenekRepository.findById(yetenekId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir yetenek bulunamadi. Id: " + yetenekId));

        yetenekRepository.deleteById(yetenekId);
    }
}