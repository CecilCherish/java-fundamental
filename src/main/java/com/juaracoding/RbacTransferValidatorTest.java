package com.juaracoding;

import java.util.Scanner;

public class RbacTransferValidatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=================================================");
        System.out.println(" FASTBANK - RBAC & TRANSFER LIMIT VALIDATOR ");
        System.out.println(" JuaraCoding SQA Bootcamp 2026 ");
        System.out.println("=================================================");
        
        // 1. Input Informasi Nasabah
        System.out.print("1. Masukkan User ID Nasabah : ");
        String userId = scanner.nextLine();
        
        System.out.print("2. Masukkan Tier Nasabah (REGULAR/GOLD/PLATINUM): ");
        String customerTier = scanner.nextLine().toUpperCase();
        
        System.out.print("3. Masukkan Saldo Aktif Rekening (IDR) : ");
        double activeBalance = scanner.nextDouble();
        
        System.out.print("4. Masukkan Nominal Transfer yang Diajukan : ");
        double transferAmount = scanner.nextDouble();
        
        System.out.print("5. Apakah PIN 6-Digit Valid? (true/false) : ");
        boolean isPinValid = scanner.nextBoolean();
        
        System.out.print("6. Apakah Token Biometrik/OTP Valid? (true/false): ");
        boolean isOtpValid = scanner.nextBoolean();

        double dailyLimit = 0.0;

        // 2. Tentukan Batas Limit Transfer Berdasarkan Tier via Switch [FIX]
        // PERBAIKAN: Menggunakan tanda panah (->)
        // double dailyLimit = switch (customerTier) {
        //     case "REGULAR" -> 10_000_000.0;    // Limit Rp 10 Juta
        //     case "GOLD" -> 50_000_000.0;       // Limit Rp 50 Juta
        //     case "PLATINUM" -> 200_000_000.0;  // Limit Rp 200 Juta
        //     default -> 0.0;                    // Tier tidak valid
        // };
        
        switch (customerTier) {
            case "REGULAR":
                dailyLimit = 10_000_000.0; // Limit Rp 10 Juta
                break;
            case "GOLD":
                dailyLimit = 50_000_000.0; // Limit Rp 50 Juta
                break;
            case "PLATINUM":
                dailyLimit = 200_000_000.0; // Limit Rp 200 Juta
                break;
            default:
                dailyLimit = 0.0; // Tier tidak valid
                break;
        }

        // 3. Evaluasi Alur Keamanan & Saldo Berlapis
        String transactionStatus;
        String reason;
        
        // PERBAIKAN: Menggunakan == untuk perbandingan
        if (dailyLimit == 0.0) {
            transactionStatus = "BLOCKED [FAIL]";
            reason = "Tier nasabah '" + customerTier + "' tidak valid / akun dibekukan.";
        } else if (!isPinValid) {
            transactionStatus = "REJECTED [FAIL]";
            reason = "Autentikasi PIN transaksi 6-digit salah.";
        } else if (transferAmount > dailyLimit) {
            transactionStatus = "REJECTED [FAIL]";
            reason = "Nominal transfer (Rp " + String.format("%,.2f", transferAmount) + ") melebihi limit harian tier " + customerTier + " (Rp " + String.format("%,.2f", dailyLimit) + ").";
        } else if (transferAmount > activeBalance) {
            transactionStatus = "REJECTED [FAIL]";
            reason = "Saldo aktif tidak mencukupi (Saldo: Rp " + String.format("%,.2f", activeBalance) + ").";
            
        // PERBAIKAN: Menggunakan >= dan &&
        } else if (transferAmount >= 25_000_000.0 && !isOtpValid) {
            transactionStatus = "CHALLENGE_REQUIRED [FAIL]";
            reason = "Transaksi bernilai tinggi (>= Rp 25 Juta) memerlukan verifikasi OTP tambahan yang valid.";
        } else {
            transactionStatus = "APPROVED [PASS]";
            reason = "Seluruh parameter validasi keamanan & limit terpenuhi.";
        }

        // 4. Tampilkan Ringkasan Evaluasi Transaksi
        System.out.println("\n=================================================");
        System.out.println(" HASIL EVALUASI TRANSAKSI DANA ");
        System.out.println("=================================================");
        System.out.println("Nasabah User ID : " + userId);
        System.out.println("Tier Akun : " + customerTier + " (Limit Harian: Rp " + String.format("%,.2f", dailyLimit) + ")");
        System.out.println("Nominal Transfer : Rp " + String.format("%,.2f", transferAmount));
        System.out.println("Sisa Limit Tier : Rp " + String.format("%,.2f", Math.max(0, dailyLimit - transferAmount)));
        System.out.println("-------------------------------------------------");
        System.out.println("STATUS TRANSAKSI : " + transactionStatus);
        System.out.println("Alasan Diagnosa : " + reason);
        System.out.println("=================================================");
        
        scanner.close();
    }
}