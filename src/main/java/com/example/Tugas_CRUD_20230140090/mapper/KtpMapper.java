package com.example.Tugas_CRUD_20230140090.mapper;

import com.example.Tugas_CRUD_20230140090.dto.KtpDto;
import com.example.Tugas_CRUD_20230140090.entity.Ktp;

public class KtpMapper {
    // Mengubah DTO menjadi Entity (Untuk menyimpan ke database)
    public static Ktp mapToEntity(KtpDto dto) {
        Ktp ktp = new Ktp();
        ktp.setId(dto.getId());
        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());
        return ktp;
    }

    // Mengubah Entity menjadi DTO (Untuk dikirim ke tampilan web)
    public static KtpDto mapToDto(Ktp ktp) {
        KtpDto dto = new KtpDto();
        dto.setId(ktp.getId());
        dto.setNomorKtp(ktp.getNomorKtp());
        dto.setNamaLengkap(ktp.getNamaLengkap());
        dto.setAlamat(ktp.getAlamat());
        dto.setTanggalLahir(ktp.getTanggalLahir());
        dto.setJenisKelamin(ktp.getJenisKelamin());
        return dto;
    }
}
