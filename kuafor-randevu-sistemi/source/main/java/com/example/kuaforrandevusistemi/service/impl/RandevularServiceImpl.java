package com.example.kuaforrandevusistemi.service.impl;

import com.example.kuaforrandevusistemi.dto.RandevularDto;
import com.example.kuaforrandevusistemi.entity.Randevular;
import com.example.kuaforrandevusistemi.exception.KaynakBulunamadiException;
import com.example.kuaforrandevusistemi.mapper.RandevularMapper;
import com.example.kuaforrandevusistemi.repository.RandevularRepository;
import com.example.kuaforrandevusistemi.service.RandevularService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RandevularServiceImpl implements RandevularService {
    private final RandevularRepository randevularRepository;
    @Override
    public RandevularDto randevuYarat(RandevularDto randevularDto) {
       Randevular randevular = RandevularMapper.mapToRandevular(randevularDto);
       Randevular kaydedilmisRandevular = randevularRepository.save(randevular);
       return RandevularMapper.mapToRandevularDto(kaydedilmisRandevular);
    }

    @Override
    public RandevularDto idIleGetir(Long randevuId) {
       Randevular randevular = randevularRepository.findById(randevuId)
               .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir randevu bulunamadi. Id: " + randevuId));
       return RandevularMapper.mapToRandevularDto(randevular);
    }

    @Override
    public List<RandevularDto> tumRandevulariGetir() {
        List<Randevular> myrandevular = randevularRepository.findAll();
        return myrandevular.stream().map((randevular) -> RandevularMapper.mapToRandevularDto(randevular))
                .collect(Collectors.toList());
    }

    @Override
    public RandevularDto randevuGuncelle(Long randevuId,RandevularDto guncellenenRandevu) {
        Randevular randevular = randevularRepository.findById(randevuId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir randevu bulunamadi. Id: " + randevuId));

        randevular.setRandevu_id(guncellenenRandevu.getRandevu_id());
        randevular.setMusteri_id(guncellenenRandevu.getMusteri_id());
        

        Randevular veritabanindaGuncellenmmisRandevu = randevularRepository.save(randevular);
        return RandevularMapper.mapToRandevularDto(veritabanindaGuncellenmmisRandevu);
    }

    @Override
    public void randevuSil(Long randevuId) {
       Randevular randevu = randevularRepository.findById(randevuId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir randevu bulunamadi. Id: " + randevuId));

        randevularRepository.deleteById(randevuId);
    }
}