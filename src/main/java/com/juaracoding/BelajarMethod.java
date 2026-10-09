package com.juaracoding;

public class BelajarMethod {
    
    public static void main(String[] args) {
       
        drawKotak(5);
        drawKotak(10);

        System.out.println(luasKotak(30));


        printTestHeader("TC-LOGIN-001: Validasi API SLA");

        long actualLatency = 600;
        boolean isSlaPass = isResponseWithinSla(actualLatency, 500);
        
            System.out.println("status SLA (<500ms)" + (isSlaPass ? "PASS" : "FAIL"));
        
            // assertEquals("SUCCESS", "SUCCESS", "Test Login API pass Success");
            // assertEquals("SUCCESS", "ERROR", "Test Login API pas Gagal");

            // assertEquals(200, 200, "API Status code harus 200");
            // assertEquals(200, 400, "API Status code harus 400");


            assertEquals("Login Sukses", "Login Sukses", "Pesan UI");
            assertEquals(200, 200, "HTTP Status Code");
            assertEquals(1450000.503, 1450000.502, 0.001, "Total Saldo");
            assertEquals(1450000.503, 1450000.502, 0.0000001, "Total Saldo");


    }

    // pakai void kalau tidak mengembalikan value (hanya menampilkan)
    public static void drawKotak(int sisi) {
        
            for (int i = 0; i < sisi; i++) {
                for (int j = 0; j < sisi; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        
    }

    public static int luasKotak(int sisi) {
        return sisi * sisi;
    }

    // 1. Method void: Mencetak log ke konsol
    public static void printTestHeader(String testName) {
        System.out.println("========================================");
        System.out.println("[RUNNING TEST] " + testName);
        System.out.println("========================================");
    }

    // 2. Method return type boolean: Validasi response time
    public static boolean isResponseWithinSla(long responseTimeMs, long maxThresholdMs) {
        return responseTimeMs <= maxThresholdMs; // 600 <= 500
    }



    //  Overload 1: Memvalidasi Teks (String)
    public static boolean assertEquals(String actual, String expected, String message) {
        boolean pass = actual.equals(expected);
        System.out.printf("[%s] Expected: '%s' | Actual: '%s'\n", (pass ? "PASS" : 
        "FAIL"), expected, actual);
        return pass;
    }
    //  Overload 2: Memvalidasi Bilangan Bulat (int)
    public static boolean assertEquals(int actual, int expected, String message) {
        boolean pass = (actual == expected);
        System.out.printf("[%s] Expected: %d | Actual: %d\n", (pass ? "PASS" : 
        "FAIL"), expected, actual);
        return pass;
    }

    //  Overload 3: Memvalidasi Desimal dengan Toleransi Delta (double)
    public static boolean assertEquals(double actual, double expected, double delta, String message) {
        boolean pass = Math.abs(actual - expected) == delta;
        System.out.printf("[%s] Expected: %.2f | Actual: %.2f (Delta: %.3f)\n", (pass ? "PASS" : "FAIL"), expected, actual, delta);
        return pass;
    }
}
