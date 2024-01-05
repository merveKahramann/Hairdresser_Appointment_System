package com.example.kuaforrandevusistemi.service.impl;

import com.example.kuaforrandevusistemi.dto.MusterilerDto;
import com.example.kuaforrandevusistemi.entity.Musteriler;
import com.example.kuaforrandevusistemi.exception.KaynakBulunamadiException;
import com.example.kuaforrandevusistemi.mapper.MusterilerMapper;
import com.example.kuaforrandevusistemi.repository.MusterilerRepository;
import com.example.kuaforrandevusistemi.service.MusterilerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MusterilerServiceImpl implements MusterilerService {
    private MusterilerRepository musterilerRepository;
    @Override
    public MusterilerDto musteriYarat(MusterilerDto musterilerDto) {
       Musteriler musteriler = MusterilerMapper.mapToMusteriler(musterilerDto);
       Musteriler kaydedilmisMusteriler = musterilerRepository.save(musteriler);
        return MusterilerMapper.mapToMusterilerDto(kaydedilmisMusteriler);
    }

    @Override
    public MusterilerDto idIleGetir(Long musteriId) {
       Musteriler musteriler = musterilerRepository.findById(musteriId)
               .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir musteri bulunamadi. Id: " + musteriId));
       return MusterilerMapper.mapToMusterilerDto(musteriler);
    }

    @Override
    public List<MusterilerDto> tumMusterileriGetir() {
        List<Musteriler> mymusteriler = musterilerRepository.findAll();
        return mymusteriler.stream().map((musteriler) -> MusterilerMapper.mapToMusterilerDto(musteriler))
                .collect(Collectors.toList());
    }

    @Override
    public MusterilerDto musteriGuncelle(Long musteriId,MusterilerDto guncellenenMusteri) {
        Musteriler musteriler = musterilerRepository.findById(musteriId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir musteri bulunamadi. Id: " + musteriId));

        musteriler.setMusteri_ad(guncellenenMusteri.getMusteri_ad());
        musteriler.setMusteri_soyad(guncellenenMusteri.getMusteri_soyad());
        musteriler.setMusteri_tel_no(guncellenenMusteri.getMusteri_tel_no());

        Musteriler veritabanindaGuncellenmmisMusteri = musterilerRepository.save(musteriler);
        return MusterilerMapper.mapToMusterilerDto(veritabanindaGuncellenmmisMusteri);
    }

    @Override
    public void musteriSil(Long musteriId) {
       Musteriler musteri = musterilerRepository.findById(musteriId)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir musteri bulunamadi. Id: " + musteriId));

        musterilerRepository.deleteById(musteriId);
    }
}