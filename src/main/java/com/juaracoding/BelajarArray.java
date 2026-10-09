package com.juaracoding;

import java.util.Locale;
import java.util.Scanner;

public class BelajarArray {
    public static void main(String[] args) {

        // Cara 1: Deklarasi dengan ukuran statis (Default value: 0 / null / false)
        String[] testCaseIds = new String[4];
        testCaseIds[0] = "TC-LOGIN-01";
        testCaseIds[1] = "TC-LOGIN-02";
        testCaseIds[2] = "TC-LOGIN-03";
        testCaseIds[3] = "TC-LOGIN-04";
        // Cara 2: Inisialisasi langsung dengan nilai (Array Literal)
        int[] responseTimes = { 240, 185, 310, 520, 195, 410 };

        // ======================================== kalau pakai scaner bisannya pakai
        // cara 1

        // String[] cars = new String[4]

        System.out.println("==========================================");

        String[][] testCases = {
                { "TC-01", "Valid Checkout", "PASS" },
                { "TC-02", "Zero Balance Payment", "FAIL" },
                { "TC-03", "Expired Voucher", "PASS" }
        };

        System.out.println(testCases[1][2]);
        System.out.println(testCases[2][1]);

        // Loop Luar: Mengiterasi Baris (Setiap Test Case)
        for (int row = 0; row < testCases.length; row++) {
            System.out.print("Baris #" + row + " /> ");
            // Loop Dalam: Mengiterasi Kolom (Atribut Data)
            for (int col = 0; col < testCases[row].length; col++) {
                System.out.print("[" + testCases[row][col] + "] ");
            }
            System.out.println();
        }

        System.out.println("===================cari data kota dan jumlah kata paling panjang=======================");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        String[] cities = { "Jakarta", "Bandung", "Surabaya", "Medan" };

        // cari kota dan index ke berapa
        System.out.println("Cari kota: ");
        String city = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equalsIgnoreCase(city)) {
                System.out.println("Kota " + city + " ditemukan pada index ke-" + i);
                found = true;
                break;
            }
        }
        if (!found) { // !true
            System.out.println("Kota " + city + " tidak ditemukan");
        }

        String longestCity = cities[0];
        for (int i = 1; i < cities.length; i++) {
            if (cities[i].length() > longestCity.length()) {
                longestCity = cities[i];
            }
        }
        System.out.println("Kota paling panjang : " + longestCity);

    }
}
