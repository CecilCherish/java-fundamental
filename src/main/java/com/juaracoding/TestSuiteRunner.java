package com.juaracoding;

public class TestSuiteRunner {
    public static void main(String[] args) {
        // Simulasi Eksekusi Test Suite
        TestCaseResult tc1 = new TestCaseResult("TC-AUTH-01", "Login dengan Kredensial Valid", "AUTH");
        tc1.markPassed(240);

        TestCaseResult tc2 = new TestCaseResult("TC-AUTH-02", "Login dengan Password Salah", "AUTH");
        tc2.markPassed(185);

        TestCaseResult tc3 = new TestCaseResult("TC-PAY-01", "Checkout dengan Saldo Cukup", "PAYMENT");
        tc3.markPassed(510);

        TestCaseResult tc4 = new TestCaseResult("TC-PAY-02", "Checkout Melebihi Daily Limit", "PAYMENT");
        tc4.markFailed(890, "AssertionError: Expected HTTP 400 but received 500");

        // Array of Objects
        TestCaseResult[] suite = {tc1, tc2, tc3, tc4};

        int totalPass = 0;
        int totalFail = 0;
        long totalDuration = 0;

        System.out.println("=======================================================================================================");
        System.out.println("                                JAVACODING AUTOMATED TEST SUITE REPORT                                 ");
        System.out.println("=======================================================================================================");
        System.out.printf("%-10s | %-12s | %-28s | %-6s | %9s | %s\n",
                "Test ID", "Modul", "Skenario Uji", "Status", "Durasi", "Detail Error");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        for (TestCaseResult tc : suite) {
            tc.printSummaryRow();
            totalDuration += tc.getExecutionDurationMs();
            if (tc.isPassed()) {
                totalPass++;
            } else {
                totalFail++;
            }
        }

        double passRate = (double) totalPass / suite.length * 100;

        System.out.println("=======================================================================================================");
        System.out.println("METRIK KUALITAS PENGUJIAN:");
        System.out.println("Total Test Executed : " + suite.length);
        System.out.println("Passed Cases        : " + totalPass + " (" + String.format("%.1f", passRate) + "%)");
        System.out.println("Failed Cases        : " + totalFail);
        System.out.println("Total Suite Time    : " + totalDuration + " ms");
        System.out.println("Suite Verdict       : " + (totalFail == 0 ? "[PASS - READY TO DEPLOY]" : "[FAIL - PIPELINE BLOCKED]"));
        
        System.out.println("=======================================================================================================");
    }
}
