package com.juaracoding;

import java.util.Scanner;
import java.util.Locale;

public class LoanCalculatorTest {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Masukkan ID Pengajuan: ");
        String loanApplicationId = scanner.nextLine();

        System.out.print("Masukkan Nama Nasabah: ");
        String borrowerName = scanner.nextLine();

        System.out.print("Masukkan Pokok Pinjaman: ");
        double principalAmount = scanner.nextDouble();

        System.out.print("Masukkan Tenor (bulan): ");
        int tenorMonths = scanner.nextInt();

        System.out.print("Masukkan Bunga Tahunan (%): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Masukkan Biaya Provisi (%): ");
        double provisionFeePercent = scanner.nextDouble();

        double provisionFeeAmount = principalAmount * (provisionFeePercent / 100.0);
        double netAmountReceived = principalAmount - provisionFeeAmount;
        
        double totalInterestAmount = principalAmount * (annualInterestRate / 100.0) * (tenorMonths / 12.0);
        double totalRepaymentAmount = principalAmount + totalInterestAmount;
        double monthlyRepayment = totalRepaymentAmount / tenorMonths;
        
        boolean isEligible = principalAmount >= 1000000.0 && principalAmount <= 50000000.0;
        
        String statusApproval;
        if (isEligible) {
            statusApproval = "ELIGIBLE [PASS]";
        } else {
            statusApproval = "NOT ELIGIBLE [FAIL]";
        }

        System.out.println("\n=======================================================");
        System.out.println("   FAST_DANA DIGITAL - QA LOAN DATA SIMULATOR");
        System.out.println("          JuaraCoding Bootcamp SQA 2026");
        System.out.println("=======================================================");
        
        System.out.printf(Locale.US, "ID Pengajuan       : %s\n", loanApplicationId);
        System.out.printf(Locale.US, "Nama Nasabah       : %s\n", borrowerName);
        System.out.printf(Locale.US, "Pokok Pinjaman     : Rp %,.2f\n", principalAmount);
        System.out.printf(Locale.US, "Tenor              : %d Bulan\n", tenorMonths);
        System.out.printf(Locale.US, "Biaya Provisi (%.1f%%): Rp %,.2f\n", provisionFeePercent, provisionFeeAmount);
        System.out.printf(Locale.US, "Dana Diterima Cair : Rp %,.2f\n", netAmountReceived);
        
        System.out.println("-------------------------------------------------------");
        
        System.out.printf(Locale.US, "Total Bunga (%.1f%%): Rp %,.2f\n", annualInterestRate, totalInterestAmount);
        System.out.printf(Locale.US, "Total Pengembalian : Rp %,.2f\n", totalRepaymentAmount);
        System.out.printf(Locale.US, "Cicilan per Bulan  : Rp %,.2f / bulan\n", monthlyRepayment);
        
        System.out.println("-------------------------------------------------------");
        
        System.out.printf(Locale.US, "Status Approval    : %s\n", statusApproval);
        System.out.println("=======================================================");

        scanner.close();
    }
}