package com.juaracoding;

public class CartMatrixValidator {

    public static void main(String[] args) {
       
        String[] namaBarang = {"Laptop Asus SDET", "Mechanical Keyboard", "Mouse Wireless", "USB-C Hub", "Monitor 24 Inch"};
        double[] hargaSatuan = {14500000, 850000, 250000, 350000, 2100000};
        int[] kuantitas = {1, 2, 2, 1, 1};
        boolean[] statusStok = {true, true, true, false, true};

        double totalBelanja = 0.0;
        double hargaTermahal = 0.0;
        String barangTermahal = "";

        System.out.println("=================================================");
        System.out.println("      STRUK RINCIAN KERANJANG BELANJA QA         ");
        System.out.println("=================================================");

        for (int i = 0; i < namaBarang.length; i++) {
            
            if (!statusStok[i]) {
                System.out.println("Warning: " + namaBarang[i] + " Stok Kosong!");
                continue; 
            }

            double subtotal = hargaSatuan[i] * kuantitas[i];
            totalBelanja += subtotal;

            System.out.println(namaBarang[i] + " (x" + kuantitas[i] + ") = Rp " + String.format("%,.0f", subtotal));

            if (hargaSatuan[i] > hargaTermahal) {
                hargaTermahal = hargaSatuan[i];
                barangTermahal = namaBarang[i];
            }
        }

        System.out.println("-------------------------------------------------");

        double diskon = 0.0;
        
        if (totalBelanja >= 10000000.0) {
            diskon = totalBelanja * 0.10; // Diskon 10%
            
            // Batas maksimal diskon Rp 1.500.000
            if (diskon > 1500000.0) {
                diskon = 1500000.0;
            }
        } else if (totalBelanja >= 5000000.0) {
            diskon = totalBelanja * 0.05; // Diskon 5%
        }

        double totalBayar = totalBelanja - diskon;

        System.out.println("Total Belanja Bersih : Rp " + String.format("%,.0f", totalBelanja));
        System.out.println("Diskon Voucher       : Rp " + String.format("%,.0f", diskon));
        System.out.println("TOTAL BAYAR          : Rp " + String.format("%,.0f", totalBayar));
        System.out.println("-------------------------------------------------");
        System.out.println("Barang Termahal      : " + barangTermahal + " (Rp " + String.format("%,.0f", hargaTermahal) + ")");
        System.out.println("=================================================");
    }
}