package com.juaracoding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringObject {
    public static void main(String[] args) {
        
        StringBuilder testLog = new StringBuilder();
        testLog.append("[INFO] Step 1: Buka Halaman Checkout\n");
        testLog.append("[INFO] Step 2: Input Data Pengiriman\n");
        testLog.append("[INFO] Step 3: Klik Tombol Bayar Sekarang\n");
        System.out.println(testLog.toString());

// 
        String rawHeader = "   Selamat Datang di Portal Pembayaran \n  ";
        String cleanHeader = rawHeader.strip();
        System.out.println("Clean Header: [" + cleanHeader + "]");

        String invoiceText = "Nomor Transaksi: INV-202610-8891 (Telah Dibayar)";
        int startIndex = invoiceText.indexOf("INV-");
        int endIndex = invoiceText.indexOf(" (");
        System.out.println(startIndex);
        System.out.println(endIndex);

        String invoiceId = invoiceText.substring(startIndex, endIndex);
        System.out.println("Extracted Invoice ID: " + invoiceId);

        // split itu punya string 

        String csvRow = "TC-101;UserCheckout;PASS;245ms";
        String[] columns = csvRow.split(";");
        System.out.println("Test ID   : " + columns[0]);
        System.out.println("Test Name : " + columns[1]);
        System.out.println("Status    : " + columns[2]);
        System.out.println("Duration  : " + columns[3]);

        // test mode punya string, apa itu toUpperCase dan toLowerCase? 

        String bootcamp = "juaracoding";
        System.out.println(bootcamp.toUpperCase());
        System.out.println(bootcamp.toLowerCase());
        System.out.println(bootcamp.length());
        System.out.println(bootcamp.charAt(0));
        System.out.println(bootcamp.replace("o","*"));
        System.out.println(bootcamp.replace("juara", "QA"));
        System.out.println(bootcamp.replaceFirst("o", "*"));

        // ============================================================

        String itemPriceText = "Price: Rp 999.000";
        String shippingFeeText = "Fee: Rp 10.000";
        
        // String itemPriceClean = itemPriceText.replace("Rp", "").replace(".", "").replace(",", ".");
        // String shippingFeeClean = shippingFeeText.replace("Rp", "").replace(".", "").replace(",", ".");

        // double itemPriceDouble = Double.parseDouble(itemPriceClean);
        // double shippingFeeDouble = Double.parseDouble(shippingFeeClean);

        double itemPriceDouble = parseRupiah(itemPriceText);
        double shippingFeeDouble = parseRupiah(shippingFeeText);

        double totalPayment = itemPriceDouble + shippingFeeDouble;

        System.out.println("Total Bayar  : " + totalPayment);

        String rawStock = "72";
        int stock = Integer.parseInt(rawStock);
        stock = stock - 5;
        System.out.println("Stock   : " + stock);
        

        // 1. Validasi Email Standar
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        String testEmail = "sdet.engineer@juaracoding.com";
        System.out.println("Email Valid? " + testEmail.matches(emailRegex));

        // 2. Validasi Nomor HP Indonesia (08xx atau +628xx atau 628xx)
        String phoneRegex = "^(\\+62|62|0)8[1-9][0-9]{7,10}$";
        String testPhone = "+6281234567890";
        System.out.println("No HP Valid? " + testPhone.matches(phoneRegex));
        
        // 3. Validasi Format Tanggal ISO (YYYY-MM-DD)
        String dateRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
        String testDate = "2026-10-08";
        System.out.println("Format Tanggal Valid? " + testDate.matches(dateRegex));

        // ===========================================================
        

        String smsNotification = "Jangan berikan kepada siapapun. Kode OTP verifikasi transaksi Anda adalah 849201. Berlaku 5 menit.";
        
        // Pola mencari 6 digit angka berurutan
        Pattern pattern = Pattern.compile("\\b(\\d{6})\\b");
        Matcher matcher = pattern.matcher(smsNotification);

        if (matcher.find()) {
        String extractedOtp = matcher.group(1);
        System.out.println(" Ekstraksi Berhasil! Kode OTP: " + extractedOtp);
        } else {
        System.out.println("Gagal menemukan kode OTP.");
        }

        // ===================================
        

        
    }

    public static double parseRupiah(String priceText) {

    return Double.parseDouble(
        priceText
            .replace("Price:", "")
            .replace("Fee:", "")
            .replace("Rp", "")
            .replace(".", "")
            .replace(",", ".")
            .trim()
    );
}
}
