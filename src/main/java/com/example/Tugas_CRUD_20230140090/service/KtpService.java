package com.example.Tugas_CRUD_20230140090.service;

import com.example.Tugas_CRUD_20230140090.dto.KtpDto;

import java.util.List;

public class KtpService {
    // Fungsi untuk menambah data KTP
    KtpDto createKtp(KtpDto ktpDto);

    // Fungsi untuk mengambil semua data KTP
    List<KtpDto> getAllKtp();

    // Fungsi untuk mengambil 1 data KTP berdasarkan ID
    KtpDto getKtpById(Integer id);

    // Fungsi untuk memperbarui data KTP
    KtpDto updateKtp(Integer id, KtpDto ktpDto);

    // Fungsi untuk menghapus data KTP
    void deleteKtp(Integer id);
}
