package com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketingStrategyManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MarketingStrategyRepository repo = new MarketingStrategyRepository();
        
        while (true) {
            System.out.println("\nMarketing Strategy Repository");
            System.out.println("1. Add Strategy");
            System.out.println("2. Fetch Strategy by Name");
            System.out.println("3. Update Strategy");
            System.out.println("4. Delete Strategy");
            System.out.println("5. List Strategies by Budget");
            System.out.println("6. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Target Audience: ");
                    String targetAudience = scanner.nextLine();
                    System.out.print("Budget: ");
                    double budget = scanner.nextDouble();
                    System.out.print("Potential ROI: ");
                    double potentialROI = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println(repo.addStrategy(name, description, targetAudience, budget, potentialROI));
                    break;
                case 2:
                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    System.out.println(repo.fetchStrategy(name));
                    break;
                case 3:
                    System.out.print("Name of strategy to update: ");
                    name = scanner.nextLine();
                    System.out.print("New Description (leave blank if no change): ");
                    description = scanner.nextLine();
                    System.out.print("New Target Audience (leave blank if no change): ");
                    targetAudience = scanner.nextLine();
                    System.out.print("New Budget (enter -1 if no change): ");
                    budget = scanner.nextDouble();
                    System.out.print("New Potential ROI (enter -1 if no change): ");
                    potentialROI = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (budget < 0) budget = -1;
                    if (potentialROI < 0) potentialROI = -1;
                    System.out.println(repo.updateStrategy(name, description.isEmpty() ? null : description, 
                                                            targetAudience.isEmpty() ? null : targetAudience, 
                                                            budget < 0 ? -1 : budget, 
                                                            potentialROI < 0 ? -1 : potentialROI));
                    break;
                case 4:
                    System.out.print("Name of strategy to delete: ");
                    name = scanner.nextLine();
                    System.out.println(repo.deleteStrategy(name));
                    break;
                case 5:
                    System.out.print("Minimum Budget: ");
                    double minBudget = scanner.nextDouble();
                    System.out.print("Maximum Budget: ");
                    double maxBudget = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println(repo.listStrategiesByBudget(minBudget, maxBudget));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
