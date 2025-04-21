//@Author - Akshaya S

package com.hexaware.cc.main;

import com.hexaware.cc.service.IReportService;
import com.hexaware.cc.service.ReportService;
import com.hexaware.cc.util.DBPropertyUtil;

import java.util.Scanner;

public class ReportRunner {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
       
        IReportService reportService = new ReportService();
        
        while (true) {
           
            System.out.println("\n--- Admin Reports Menu ---");
            System.out.println("1. Reservation History Report");
            System.out.println("2. Vehicle Utilization Report");
            System.out.println("3. Revenue Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            
         
            int choice = sc.nextInt();
            
           
            switch (choice) {
                case 1:
                    reportService.generateReservationHistoryReport();
                    break;
                case 2:
                 
                    reportService.generateVehicleUtilizationReport();
                    break;
                case 3:
                   
                    reportService.generateRevenueReport();
                    break;
                case 0:
                  
                    System.out.println("Exiting Reports Module.");
                    return; 
                default:
                 
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
