package com.example.Tugas_CRUD_20230140090.repository;

import com.example.Tugas_CRUD_20230140090.entity.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KtpRepository extends JpaRepository<Ktp, Integer> {

    // Fungsi khusus untuk mengecek apakah nomor KTP sudah ada di database
    boolean existsByNomorKtp(String nomorKtp);

}
