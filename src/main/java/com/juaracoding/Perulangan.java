package com.juaracoding;

public class Perulangan {

    public static void main(String[] args) {
        // for (int i = 0; i < 10; i++) {
        //     System.out.println(i);
        // }

        int sisi = 5;

        System.out.println("Nested for kotak");
        for (int i = 0; i < sisi; i++) {
            for (int j = 0; j < sisi; j++) {
            System.out.print("*  ");
            }
            System.out.println();
        }

        System.out.println("Nested for segitiga");
        for (int i = sisi; i > 1; i--) {
            for (int j = 1; j < i; j++) {
            System.out.print("*  ");
            }
            System.out.println();
        }

        String[]  browserList = {"Chrome","Firefox","Edge"};
        for (String browser : browserList) {
            System.out.println(browser);
        }


        int x = 1;
        while (x < 1) {
            System.out.println("x : " + x);
            x++;
        }

        
        int y = 1;
        do {
            System.out.println("y : " + y);
            y++;
            
        } while (y < 0);

        
        System.out.println("==========================================================");


        int httpStatusCode;
        int attempt = 0;
        do {
        attempt++;
        System.out.println("Mengirim API Request (Attempt #" + attempt + ")...");
        httpStatusCode = (attempt == 2) ? 200 : 503;
        } while (httpStatusCode != 200 && attempt < 3);
        System.out.println("Status Akhir: " + httpStatusCode);


        System.out.println("==========================================================");


        String[] testResults = {"PASS", "PASS", "FAIL", "PASS", "BLOCKED", "PASS"};

        System.out.println("//= Demonstrasi CONTINUE (Skip PASS, tampilkan anomali) //=");
        for (String result : testResults) {
        if (result.equals("PASS")) {
            continue; // Lewati jika PASS, jangan cetak
            }
            System.out.println("Ditemukan anomali pengujian: " + result);
        }
        System.out.println("\n//= Demonstrasi BREAK (Hentikan eksekusi jika FAIL kritis)//=");
        for (int i = 0; i < testResults.length; i++) {
        if (testResults[i].equals("FAIL")) {
        System.out.println("Kritikal Bug pada Test #" + (i + 1) + "! Menghentikan Test Suite.");
        break; // Keluar dari loop seketika
        }
        System.out.println("Test #" + (i + 1) + " OK.");
        }



        System.out.println("==========================================================");

        for (int i = 0; i < 10; i++) {
            if (i==7){
                break;
            }
            System.out.println("i : " + i);
        }

    }
}
