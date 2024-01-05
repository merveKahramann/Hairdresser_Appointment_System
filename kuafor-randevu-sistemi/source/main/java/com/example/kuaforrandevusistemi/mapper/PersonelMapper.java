
package com.example.kuaforrandevusistemi.mapper;
import com.example.kuaforrandevusistemi.dto.PersonelDto;
import com.example.kuaforrandevusistemi.entity.Personel;



public class PersonelMapper {
    public static PersonelDto mapToPersonelDto(Personel personel){
        return new PersonelDto(
                personel.getId(),
                personel.getKuafor_ad(),
                personel.getKuafor_soyad(),
                personel.getKuafor_tel_no(),
                personel.getAlan_ad(),
                personel.getAlan_id(),
                personel.getTarih(),
                personel.getSeans()
        );
    }

    public static Personel mapToPersonel(PersonelDto personelDto){
        return new Personel(
                personelDto.getKuafor_id(),
                personelDto.getKuafor_ad(),
                personelDto.getKuafor_soyad(),
                personelDto.getKuafor_tel_no(),
                personelDto.getAlan_ad(),
                personelDto.getAlan_id(),
                personelDto.getTarih(),
                personelDto.getSeans()
        );
    }
}