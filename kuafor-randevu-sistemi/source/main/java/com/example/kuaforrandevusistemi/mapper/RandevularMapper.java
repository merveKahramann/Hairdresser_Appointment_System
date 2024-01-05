
package com.example.kuaforrandevusistemi.mapper;
import com.example.kuaforrandevusistemi.dto.RandevularDto;
import com.example.kuaforrandevusistemi.entity.Randevular;



public class RandevularMapper {
    public static RandevularDto mapToRandevularDto(Randevular randevular){
        return new RandevularDto(
                randevular.getRandevu_id(),
                randevular.getMusteri_id()
        
        );
    }

    public static Randevular mapToRandevular(RandevularDto randevularDto){
        return new Randevular(
                randevularDto.getMusteri_id(),
                randevularDto.getRandevu_id()
             
        );
    }
}