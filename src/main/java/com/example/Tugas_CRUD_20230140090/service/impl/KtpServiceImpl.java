package com.example.Tugas_CRUD_20230140090.service.impl;

import com.example.Tugas_CRUD_20230140090.dto.KtpDto;
import com.example.Tugas_CRUD_20230140090.entity.Ktp;
import com.example.Tugas_CRUD_20230140090.mapper.KtpMapper;
import com.example.Tugas_CRUD_20230140090.repository.KtpRepository;
import com.example.Tugas_CRUD_20230140090.service.KtpService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {
    private final KtpRepository ktpRepository;

    // Injection KtpRepository melalui constructor
    public KtpServiceImpl(KtpRepository ktpRepository) {
        this.ktpRepository = ktpRepository;
    }

    @Override
    public KtpDto createKtp(KtpDto ktpDto) {
        // Validasi: Cek apakah Nomor KTP sudah ada di database
        if (ktpRepository.existsByNomorKtp(ktpDto.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }

        // Ubah DTO dari request menjadi Entity untuk disimpan ke database
        Ktp ktp = KtpMapper.mapToEntity(ktpDto);
        Ktp savedKtp = ktpRepository.save(ktp);

        // Kembalikan hasilnya dalam bentuk DTO
        return KtpMapper.mapToDto(savedKtp);
    }

    @Override
    public List<KtpDto> getAllKtp() {
        // Ambil semua data dari database, lalu ubah satu-satu menjadi DTO
        return ktpRepository.findAll().stream()
                .map(KtpMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getKtpById(Integer id) {
        // Cari data berdasarkan ID. Jika tidak ketemu, lemparkan error
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP dengan ID " + id + " tidak ditemukan"));
        return KtpMapper.mapToDto(ktp);
    }

    @Override
    public KtpDto updateKtp(Integer id, KtpDto ktpDto) {
        // Cari data lamanya dulu
        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP dengan ID " + id + " tidak ditemukan"));

        // Update datanya (Nomor KTP biasanya tidak boleh diubah, jadi kita skip)
        existingKtp.setNamaLengkap(ktpDto.getNamaLengkap());
        existingKtp.setAlamat(ktpDto.getAlamat());
        existingKtp.setTanggalLahir(ktpDto.getTanggalLahir());
        existingKtp.setJenisKelamin(ktpDto.getJenisKelamin());

        // Simpan perubahan ke database
        Ktp updatedKtp = ktpRepository.save(existingKtp);
        return KtpMapper.mapToDto(updatedKtp);
    }

    @Override
    public void deleteKtp(Integer id) {
        // Cek dulu apakah datanya ada
        if (!ktpRepository.existsById(id)) {
            throw new RuntimeException("Data KTP dengan ID " + id + " tidak ditemukan");
        }
        // Hapus data
        ktpRepository.deleteById(id);
    }
}
