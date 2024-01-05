
package com.example.kuaforrandevusistemi.mapper;
import com.example.kuaforrandevusistemi.dto.YetenekDto;
import com.example.kuaforrandevusistemi.entity.Yetenek;


public class YetenekMapper {
    public static YetenekDto mapToYetenekDto(Yetenek yetenek){
        return new YetenekDto(
                yetenek.getAlan_id(),
                yetenek.getAlan_ad()
        );
    }

    public static Yetenek mapToYetenek(YetenekDto yetenekDto){
        return new Yetenek(
            yetenekDto.getAlan_id(),
            yetenekDto.getAlan_ad()
        );
    }
}