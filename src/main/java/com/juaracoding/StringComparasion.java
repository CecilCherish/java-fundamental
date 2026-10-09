package com.juaracoding;

// import java.util.Scanner;

public class StringComparasion {
    public static void main(String[] args) {
        String expectedTitle = "Dashboard Admin";
        String actualTitle = new String("Dashboard Admin");

        System.out.println("Hasil (==)(primitif) : " + (expectedTitle == actualTitle));
        System.out.println("Hasil (.equals()) : " + expectedTitle.equals(actualTitle));

        String nama1 = "Budi";
        String nama2 = new String("Budi");

        System.out.println("Hasil (==)(Primitif) : " + (nama1 == nama2));
        System.out.println("Hasil (.equals())  : " + nama1.equals(nama2));

    }
}
