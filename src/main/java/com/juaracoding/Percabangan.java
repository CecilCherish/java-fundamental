package com.juaracoding;

import java.util.Locale;
import java.util.Scanner;

public class Percabangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals("che") && password.equals("123")) {
            System.out.println("Login Berhasil!");

            int stokKomputer = 15;

            System.out.print("Masukkan jumlah pesanan komputer " + stokKomputer + " unit : ");
            int pesanan = scanner.nextInt();

            if (stokKomputer == 0 || pesanan <= 0) {
                System.out.println("Tidak bisa dipesan karena habis");
            } else if (pesanan > stokKomputer) {
                System.out.println("Pesanan gagal: Barang stok tidak cukup");
            } else {
                System.out.println("Pesanan berhasil dipilih");

                System.out.println("\nPilih Lokasi Pengiriman:");
                System.out.println("1. Jakarta");
                System.out.println("2. Bandung");
                System.out.println("3. Bogor");
                System.out.print("Masukkan angka pilihan kota (1/2/3): ");
                int pilihanKota = scanner.nextInt();

                int ongkosKirim = 0;
                String namaKota = "";

                if (pilihanKota == 1) {
                    namaKota = "Jakarta";
                    ongkosKirim = 50000;
                } else if (pilihanKota == 2) {
                    namaKota = "Bandung";
                    ongkosKirim = 150000;
                } else if (pilihanKota == 3) {
                    namaKota = "Bogor";
                    ongkosKirim = 100000;
                } else {
                    System.out.println("Pilihan tidak valid!");
                    return;
                }
                // switch (pilihanKota) {
                //     case 1 -> {
                //         namaKota = "Jakarta";
                //         ongkosKirim = 50000;
                //     }
                //     case 2 -> {
                //         namaKota = "Bandung";
                //         ongkosKirim = 150000;
                //     }
                //     case 3 -> {
                //         namaKota = "Bogor";
                //         ongkosKirim = 100000;
                //     }
                //     default -> {
                //         System.out.println("Pilihan tidak valid!");
                //         return;
                //     }
                // }

                System.out.println("\n=== HASIL TRANSAKSI ===");
                System.out.println("Jumlah Pesanan : " + pesanan + " Unit");
                System.out.println("Tujuan Kirim   : " + namaKota);
                System.out.println("Ongkos Kirim   : Rp " + ongkosKirim);
                System.out.println("===========================");
            }
        } else {
            System.out.println("Login Gagal! Username atau password salah");
        }

        scanner.close();
    }
}