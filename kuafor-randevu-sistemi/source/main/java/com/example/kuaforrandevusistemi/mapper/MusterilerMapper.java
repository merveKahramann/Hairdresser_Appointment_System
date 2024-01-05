
package com.example.kuaforrandevusistemi.mapper;
import com.example.kuaforrandevusistemi.dto.MusterilerDto;
import com.example.kuaforrandevusistemi.entity.Musteriler;



public class MusterilerMapper {
    public static MusterilerDto mapToMusterilerDto(Musteriler musteriler){
        return new MusterilerDto(
                musteriler.getMusteri_id(),
                musteriler.getMusteri_ad(),
                musteriler.getMusteri_soyad(),
                musteriler.getMusteri_tel_no(),
                musteriler.getMusteri_kullanici_ad(),
                musteriler.getMusteri_sifre(),
                musteriler.getMusteri_tarih(),
                musteriler.getMusteri_seans()
        );
    }

    public static Musteriler mapToMusteriler(MusterilerDto musterilerDto){
        return new Musteriler (
                musterilerDto.getMusteri_id(),
                musterilerDto.getMusteri_ad(),
                musterilerDto.getMusteri_soyad(),
                musterilerDto.getMusteri_tel_no(),
                musterilerDto.getMusteri_kullanici_ad(),
                musterilerDto.getMusteri_sifre(),
                musterilerDto.getMusteri_tarih(),
                musterilerDto.getMusteri_seans()
        );
    }
}