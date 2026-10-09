package com.juaracoding;

import java.util.Scanner;

public class ScholarshipEvaluatorTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("  INPUT DATA PENDAFTAR BEASISWA JUARACODING     ");
        System.out.println("=================================================");

        System.out.print("Masukkan ID Pendaftar (contoh: BEASISWA-2026-8801)   : ");
        String applicantId = scanner.nextLine().trim();

        System.out.print("Masukkan Nama Lengkap Pendaftar                      : ");
        String applicantName = scanner.nextLine().trim();

        System.out.print("Masukkan Jenjang Pendidikan (SMK / D3 / S1 / S2)     : ");
        String educationLevel = scanner.nextLine().trim();

        System.out.print("Masukkan Skor Tes Logika (0.0 s/d 100.0)             : ");
        double logicScore = scanner.nextDouble();

        System.out.print("Masukkan Skor Tes Coding Java Dasar (0.0 s/d 100.0)  : ");
        double codingScore = scanner.nextDouble();

        System.out.print("Apakah Dokumen Administrasi Lengkap? (true / false)  : ");
        boolean hasCompletedDocuments = scanner.nextBoolean();

        System.out.print("Masukkan Pengalaman Kerja dalam Tahun (contoh: 0, 2) : ");
        int yearsOfExperience = scanner.nextInt();

        String formattedEducation;
        switch (educationLevel.toUpperCase()) {
            case "SMK":
                formattedEducation = "SMK";
                break;
            case "D3":
                formattedEducation = "D3";
                break;
            case "S1":
                formattedEducation = "S1";
                break;
            case "S2":
                formattedEducation = "S2";
                break;
            default:
                formattedEducation = educationLevel.toUpperCase();
                break;
        }

        double averageScore = (logicScore * 0.40) + (codingScore * 0.60);

        String grade;
        if (averageScore >= 85.0) {
            grade = "A (EXCELLENT)";
        } else if (averageScore >= 75.0) {
            grade = "B (GOOD)";
        } else if (averageScore >= 65.0) {
            grade = "C (SATISFACTORY)";
        } else {
            grade = "D (UNQUALIFIED)";
        }

        String scholarshipCategory;
        String testStatus;

        if (!hasCompletedDocuments) {
            scholarshipCategory = "REJECTED (Dokumen Administrasi Tidak Lengkap)";
            testStatus = "FAIL [NOT QUALIFIED]";
        } else {
            if (averageScore >= 85.0) {
                scholarshipCategory = "FULL_SCHOLARSHIP_100% (Beasiswa Penuh Bebas Biaya)";
                testStatus = "PASS [QUALIFIED]";
            } else if (averageScore >= 75.0) {
                if (yearsOfExperience >= 1) {
                    scholarshipCategory = "PARTIAL_SCHOLARSHIP_75%";
                } else {
                    scholarshipCategory = "PARTIAL_SCHOLARSHIP_50%";
                }
                testStatus = "PASS [QUALIFIED]";
            } else {
                scholarshipCategory = "REGULAR_ADMISSION (Tidak Mendapatkan Beasiswa)";
                testStatus = "FAIL [NOT QUALIFIED]";
            }
        }

        String documentStatusText = hasCompletedDocuments ? "Lengkap (TRUE)" : "Tidak Lengkap (FALSE)";

        System.out.println("\n=================================================");
        System.out.println("JUARACODING - SCHOLARSHIP QUALIFICATION ENGINE");
        System.out.println("Bootcamp SQA Automation 2026");
        System.out.println("=================================================");
        System.out.println("ID Pendaftar        : " + applicantId);
        System.out.println("Nama Lengkap        : " + applicantName);
        System.out.println("Pendidikan Terakhir : " + formattedEducation);
        System.out.println("Pengalaman Kerja    : " + yearsOfExperience + " Tahun");
        System.out.println("Dokumen Lengkap     : " + documentStatusText);
        System.out.println("-------------------------------------------------");
        
        System.out.println("Skor Tes Logika     : " + String.format("%.2f", logicScore) + " (Bobot 40%)");
        System.out.println("Skor Tes Coding     : " + String.format("%.2f", codingScore) + " (Bobot 60%)");
        System.out.println("SKOR RATA-RATA      : " + String.format("%.2f", averageScore));
        
        System.out.println("GRADE PENCAPAIAN    : " + grade);
        System.out.println("-------------------------------------------------");
        System.out.println("HASIL KELAYAKAN     : " + scholarshipCategory);
        System.out.println("STATUS PENGUJIAN    : " + testStatus);
        System.out.println("=================================================");

        scanner.close();
    }
}