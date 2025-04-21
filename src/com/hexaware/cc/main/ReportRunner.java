//@Author - Akshaya S

package com.hexaware.cc.main;

import com.hexaware.cc.service.IReportService;
import com.hexaware.cc.service.ReportService;
import com.hexaware.cc.util.DBPropertyUtil;

import java.util.Scanner;

public class ReportRunner {
    public static void main(String[] args) {
        // Create a scanner object to get user input
        Scanner sc = new Scanner(System.in);
        
        // Initialize the ReportService to access report generation methods 
        IReportService reportService = new ReportService();
        
        while (true) {
            // Display the Admin Reports Menu
            System.out.println("\n--- Admin Reports Menu ---");
            System.out.println("1. Reservation History Report");
            System.out.println("2. Vehicle Utilization Report");
            System.out.println("3. Revenue Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            
            // Capture the user's choice
            int choice = sc.nextInt();
            
            // Switch case to perform actions based on the user's choice
            switch (choice) {
                case 1:
                    // Generate Reservation History Report
                    reportService.generateReservationHistoryReport();
                    break;
                case 2:
                    // Generate Vehicle Utilization Report
                    reportService.generateVehicleUtilizationReport();
                    break;
                case 3:
                    // Generate Revenue Report
                    reportService.generateRevenueReport();
                    break;
                case 0:
                    // Exit the program if the user chooses to
                    System.out.println("Exiting Reports Module.");
                    return; // Exit the loop and program
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
