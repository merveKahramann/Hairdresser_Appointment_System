package com.example.kuaforrandevusistemi.controller;

import com.example.kuaforrandevusistemi.dto.YetenekDto;
import com.example.kuaforrandevusistemi.service.YetenekService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.EmptyStackException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/yetenekler")
public class YetenekController {
    private YetenekService yetenekService;

    //Personel ekleme islemi
    @PostMapping
    public ResponseEntity<YetenekDto> yetenekYarat(@RequestBody YetenekDto yetenekDto) {
       YetenekDto kayitEdilmisYetenek=yetenekService.yetenekYarat(yetenekDto);
        return new ResponseEntity<>(kayitEdilmisYetenek, HttpStatus.CREATED);
    }

    //Personel getirme islemi
    @GetMapping("{id}")
    public ResponseEntity<YetenekDto> idIleGetir(@PathVariable("id") Long yetenekId){
       YetenekDto yetenekDto= yetenekService.idIleGetir(yetenekId);
       return ResponseEntity.ok(yetenekDto);
    }

    //Tum personelleri getirme islemi
    @GetMapping
    public ResponseEntity<List<YetenekDto>> tumYetenekleriGetir(){
        List<YetenekDto> randevularDtoList = yetenekService.tumYetenekleriGetir();
        return ResponseEntity.ok(randevularDtoList);
    }

    //personel guncelleme
    @PutMapping("{id}")
    public ResponseEntity<YetenekDto> yetenekGuncelle(@PathVariable("id") Long yetenekId,
                                                        @RequestBody YetenekDto guncelYetenekDto){
       YetenekDto yetenekDto =yetenekService.yetenekGuncelle(yetenekId,guncelYetenekDto);
        return ResponseEntity.ok(yetenekDto);
    }

    //Personel Silme
    @DeleteMapping("{id}")
    public ResponseEntity<String> yetenekSil(@PathVariable("id") Long yetenekId){
        yetenekService.yetenekSil(yetenekId);
        return ResponseEntity.ok("Yetenek basariyla silindi.");
    }
}

