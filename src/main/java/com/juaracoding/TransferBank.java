
package com.juaracoding;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransferBank {

    public static void main(String[] args) {

        String[] rawTransfers = {
            "TRX: FT20261008-882190 | Waktu: 2026-10-08 09:15:30 | Rek Asal: 5210984122 (Budi Santoso) | Rek Tujuan: BCA-8830192841 (Siti Rahma) | Nominal: Rp 2.500.000,00 | Tipe: BI-FAST | Status: SUCCESS",
            "TRX: FT20261008-882191 | Waktu: 2026-10-08 11:20:10 | Rek Asal: 5210984122 (Budi Santoso) | Rek Tujuan: MANDIRI-1200098124 (Toko Komputer) | Nominal: Rp 14.750.000,00 | Tipe: REALTIME_ONLINE | Status: SUCCESS",
            "TRX: FT20261008-882192 | Waktu: 2026-10-08 14:45:00 | Rek Asal: 5210984122 (Budi Santoso) | Rek Tujuan: BRI-0209182391 (Andi Wijaya) | Nominal: Rp 500.000,00 | Tipe: BI-FAST | Status: SUCCESS",
            "TRX: FT20261008-882193 | Waktu: 2026-10-08 20:10:45 | Rek Asal: 5210984122 (Budi Santoso) | Rek Tujuan: BNI-9910293841 (Rina Amelia) | Nominal: Rp 50.000.000,00 | Tipe: RTGS | Status: SUCCESS"
        };

        Pattern pattern = Pattern.compile(
            "TRX:\\s*(FT\\d{8}-\\d{6})\\s*\\|\\s*" +
            "Waktu:\\s*(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})\\s*\\|\\s*" +
            "Rek Asal:.*?\\|\\s*" +
            "Rek Tujuan:\\s*([A-Z]+-\\d+)\\s*\\(([^)]+)\\)\\s*\\|\\s*" +
            "Nominal:\\s*Rp\\s*([\\d.,]+)\\s*\\|\\s*" +
            "Tipe:\\s*(BI-FAST|REALTIME_ONLINE|RTGS)\\s*\\|\\s*" +
            "Status:\\s*(\\w+)"
        );

        DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        NumberFormat rupiahFormatter =
            NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        LocalTime rtgsCutOff = LocalTime.of(15, 0, 0);

        double totalTransfer = 0;
        double totalAdmin = 0;
        double grandTotalDebit = 0;

        // laporan
        System.out.println("==============================================================================================");
        System.out.println("                    LAPORAN AUDIT QA - MUTASI TRANSFER BANK");
        System.out.println("==============================================================================================");

        System.out.printf(
            "%-20s | %-20s | %-15s | %-17s | %-14s | %-17s | %s%n",
            "Kode Transaksi", "Rekening Tujuan", "Tipe Transfer",
            "Nominal Transfer", "Biaya Admin", "Total Debit", "Status Kliring"
        );

        System.out.println("----------------------------------------------------------------------------------------------");

        // transaksi
        for (String raw : rawTransfers) {

            Matcher matcher = pattern.matcher(raw);

            if (matcher.find()) {

                String transactionCode = matcher.group(1);
                String timestampText = matcher.group(2);
                String destinationAccount = matcher.group(3);
                String destinationName = matcher.group(4);
                String nominalText = matcher.group(5);
                String transferType = matcher.group(6);
                String transactionStatus = matcher.group(7);
                
                String cleanNominal = nominalText
                    .replace(".", "")
                    .replace(",", ".");

                double transferAmount = Double.parseDouble(cleanNominal);

                double adminFee;

                switch (transferType) {
                    case "BI-FAST":
                        adminFee = 2500;
                        break;

                    case "REALTIME_ONLINE":
                        adminFee = 6500;
                        break;

                    case "RTGS":
                        adminFee = 30000;
                        break;

                    default:
                        adminFee = 0;
                }

                double totalDebit = transferAmount + adminFee;
               
                LocalDateTime transactionDateTime =
                    LocalDateTime.parse(timestampText, dateFormatter);

                LocalTime transactionTime =
                    transactionDateTime.toLocalTime();

                String clearingStatus = "-";

                if (transferType.equals("RTGS")) {

                    if (transactionTime.isAfter(rtgsCutOff)) {
                        clearingStatus = "[PENDING_NEXT_DAY_SETTLEMENT]";
                    } else {
                        clearingStatus = "[SAME_DAY_SETTLED]";
                    }
                } else {
                        clearingStatus = "[SAME_DAY_SETTLED]";
                    }

                System.out.printf(
                    "%-20s | %-20s | %-15s | %17s | %14s | %17s | %s%n",
                    transactionCode,
                    destinationAccount,
                    transferType,
                    rupiahFormatter.format(transferAmount),
                    rupiahFormatter.format(adminFee),
                    rupiahFormatter.format(totalDebit),
                    clearingStatus
                );

                System.out.println("  Nama Penerima: " + destinationName + " | Status Transaksi: " + transactionStatus);

                totalTransfer += transferAmount;
                totalAdmin += adminFee;
                grandTotalDebit += totalDebit;

            } else {
                System.out.println("GAGAL: Format data transaksi tidak valid.");
            }
        }

        System.out.println("==============================================================================================");
        System.out.println("REKAPITULASI QA");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Total Transfer Bersih          : " + rupiahFormatter.format(totalTransfer));
        System.out.println("Total Biaya Admin Perbankan    : " + rupiahFormatter.format(totalAdmin));
        System.out.println("Total Pengurangan Saldo        : " + rupiahFormatter.format(grandTotalDebit));
        System.out.println("==============================================================================================");
    }
}