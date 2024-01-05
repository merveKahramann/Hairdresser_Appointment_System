package com.example.kuaforrandevusistemi.controller;

import com.example.kuaforrandevusistemi.dto.RandevularDto;
import com.example.kuaforrandevusistemi.service.RandevularService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.EmptyStackException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/randevular")
public class RandevularController {
    private RandevularService randevularService;

    //Personel ekleme islemi
    @PostMapping
    public ResponseEntity<RandevularDto> randevuYarat(@RequestBody RandevularDto randevularDto) {
       RandevularDto kayitEdilmisRandevular=randevularService.randevuYarat(randevularDto);
        return new ResponseEntity<>(kayitEdilmisRandevular, HttpStatus.CREATED);
    }

    //Personel getirme islemi
    @GetMapping("{id}")
    public ResponseEntity<RandevularDto> idIleGetir(@PathVariable("id") Long randevuId){
       RandevularDto randevularDto= randevularService.idIleGetir(randevuId);
       return ResponseEntity.ok(randevularDto);
    }

    //Tum personelleri getirme islemi
    @GetMapping
    public ResponseEntity<List<RandevularDto>> tumRandevulariGetir(){
        List<RandevularDto> randevularDtoList = randevularService.tumRandevulariGetir();
        return ResponseEntity.ok(randevularDtoList);
    }

    //personel guncelleme
    @PutMapping("{id}")
    public ResponseEntity<RandevularDto> randevuGuncelle(@PathVariable("id") Long randevuId,
                                                        @RequestBody RandevularDto guncelRandevuDto){
       RandevularDto randevularDto =randevularService.randevuGuncelle(randevuId,guncelRandevuDto);
        return ResponseEntity.ok(randevularDto);
    }

    //Personel Silme
    @DeleteMapping("{id}")
    public ResponseEntity<String> randevuSil(@PathVariable("id") Long randevuId){
        randevularService.randevuSil(randevuId);
        return ResponseEntity.ok("Randevu basariyla silindi.");
    }
}

