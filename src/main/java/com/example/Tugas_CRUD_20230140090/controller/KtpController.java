package com.example.Tugas_CRUD_20230140090.controller;


import com.example.Tugas_CRUD_20230140090.dto.KtpDto;
import com.example.Tugas_CRUD_20230140090.model.WebResponse;
import com.example.Tugas_CRUD_20230140090.service.KtpService;
import com.example.Tugas_CRUD_20230140090.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") //agar API bisa diakses oleh jQuery AJAX dari HTML
@RestController
@RequestMapping("/ktp")
public class KtpController {
    private final KtpService ktpService;

    // Injection Service
    public KtpController(KtpService ktpService) {
        this.ktpService = ktpService;
    }

    // 1. Endpoint untuk Menambah Data KTP (POST /ktp)
    @PostMapping
    public ResponseEntity<WebResponse<KtpDto>> createKtp(@RequestBody KtpDto ktpDto) {
        try {
            KtpDto created = ktpService.createKtp(ktpDto);
            return ResponseUtil.buildSuccessResponse("Data berhasil ditambahkan", created, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseUtil.buildErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // 2. Endpoint untuk Mengambil Semua Data KTP (GET /ktp)
    @GetMapping
    public ResponseEntity<WebResponse<List<KtpDto>>> getAllKtp() {
        List<KtpDto> data = ktpService.getAllKtp();
        return ResponseUtil.buildSuccessResponse("Berhasil mengambil data KTP", data, HttpStatus.OK);
    }

    // 3. Endpoint untuk Mengambil Data KTP Berdasarkan ID (GET /ktp/{id})
    @GetMapping("/{id}")
    public ResponseEntity<WebResponse<KtpDto>> getKtpById(@PathVariable Integer id) {
        try {
            KtpDto ktpDto = ktpService.getKtpById(id);
            return ResponseUtil.buildSuccessResponse("Data ditemukan", ktpDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseUtil.buildErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // 4. Endpoint untuk Memperbarui Data KTP (PUT /ktp/{id})
    @PutMapping("/{id}")
    public ResponseEntity<WebResponse<KtpDto>> updateKtp(@PathVariable Integer id, @RequestBody KtpDto ktpDto) {
        try {
            KtpDto updated = ktpService.updateKtp(id, ktpDto);
            return ResponseUtil.buildSuccessResponse("Data berhasil diperbarui", updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseUtil.buildErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // 5. Endpoint untuk Menghapus Data KTP (DELETE /ktp/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<WebResponse<Void>> deleteKtp(@PathVariable Integer id) {
        try {
            ktpService.deleteKtp(id);
            return ResponseUtil.buildSuccessResponse("Data berhasil dihapus", null, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseUtil.buildErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
