package com.example.kuaforrandevusistemi.controller;

import com.example.kuaforrandevusistemi.dto.MusterilerDto;
import com.example.kuaforrandevusistemi.service.MusterilerService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.EmptyStackException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/musteriler")
public class MusterilerController {
    private MusterilerService musterilerService;

    //Personel ekleme islemi
    @PostMapping
    public ResponseEntity<MusterilerDto> musteriYarat(@RequestBody MusterilerDto musterilerDto) {
        MusterilerDto kayitEdilmisMusteriler= musterilerService.musteriYarat(musterilerDto);
        return new ResponseEntity<>(kayitEdilmisMusteriler, HttpStatus.CREATED);
    }

    //Personel getirme islemi
    @GetMapping("{id}")
    public ResponseEntity<MusterilerDto> idIleGetir(@PathVariable("id") Long musteriId){
       MusterilerDto musterilerDto= musterilerService.idIleGetir(musteriId);
       return ResponseEntity.ok(musterilerDto);
    }

    //Tum personelleri getirme islemi
    @GetMapping
    public ResponseEntity<List<MusterilerDto>> tumMusterileriGetir(){
        List<MusterilerDto> musterilerDtoList = musterilerService.tumMusterileriGetir();
        return ResponseEntity.ok(musterilerDtoList);
    }

    //personel guncelleme
    @PutMapping("{id}")
    public ResponseEntity<MusterilerDto> musteriGuncelle(@PathVariable("id") Long musteriId,
                                                        @RequestBody MusterilerDto guncelMusteriDto){
        MusterilerDto musterilerDto =musterilerService.musteriGuncelle(musteriId,guncelMusteriDto);
        return ResponseEntity.ok(musterilerDto);
    }

    //Personel Silme
    @DeleteMapping("{id}")
    public ResponseEntity<String> musteriSil(@PathVariable("id") Long musteriId){
        musterilerService.musteriSil(musteriId);
        return ResponseEntity.ok("Musteri basariyla silindi.");
    }
}

