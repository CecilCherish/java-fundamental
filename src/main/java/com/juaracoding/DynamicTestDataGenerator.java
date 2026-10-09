package com.juaracoding;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DynamicTestDataGenerator {
public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();

// Pola: TahunBulanTanggal_JamMenitDetik
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    String timestamp = now.format(formatter);
    String uniqueEmail = "user_test_" + timestamp + "@juaracoding.com";
    String uniqueInvoice = "INV-" + timestamp;
    System.out.println("Generated Dynamic Email   : " + uniqueEmail);
    System.out.println("Generated Dynamic Invoice : " + uniqueInvoice);

}
}

