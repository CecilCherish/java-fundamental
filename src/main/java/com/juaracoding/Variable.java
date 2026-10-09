package com.juaracoding;

import java.util.Scanner;

public class Variable {

    public static void main(String[] args) {
        int httpStatusCode = 200;
        long accountBalance = 150_000_000L;
        double itemPrice = 749_999.50;
        boolean isElementVisible = true;
        char currencySymbol = '$';

        String testCaseId = "TC-LOGIN-001";
        String expectedMessage = "Login Berhasil Diproses";

        System.out.println("ID Kasus Uji    : " + testCaseId);
        System.out.println("Status Respons  : " + httpStatusCode);
        System.out.println("Saldo Akun      : Rp " + accountBalance);
        System.out.println("Harga Produk    : " + currencySymbol + itemPrice);
        System.out.println("Elemen Muncul   : " + isElementVisible);
        System.out.println("Pesan Diharapkan: " + expectedMessage);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Username Tester: ");
        String username = scanner.nextLine();
        // </ Membaca teks hingga tombol Enter

        System.out.print("Masukkan Nominal Transfer: ");
        double amount = scanner.nextDouble();
        // </ Membaca bilangan pecahan
        System.out.println("\n[LOG] Transaksi dibuat oleh: " + username + " sebesar Rp" + amount);
        scanner.close();
    }

}
