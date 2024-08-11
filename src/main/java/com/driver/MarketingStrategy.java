import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MarketingStrategy {
    private String name;
    private String description;
    private String targetAudience;
    private double budget;
    private double potentialROI;

    public MarketingStrategy(String name, String description, String targetAudience, double budget, double potentialROI) {
        this.name = name;
        this.description = description;
        this.targetAudience = targetAudience;
        this.budget = budget;
        this.potentialROI = potentialROI;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public double getBudget() {
        return budget;
    }

    public double getPotentialROI() {
        return potentialROI;
    }

    public void updateDetails(String description, String targetAudience, double budget, double potentialROI) {
        if (description != null && !description.isEmpty()) this.description = description;
        if (targetAudience != null && !targetAudience.isEmpty()) this.targetAudience = targetAudience;
        if (budget >= 0) this.budget = budget;
        if (potentialROI >= 0) this.potentialROI = potentialROI;
    }

    @Override
    public String toString() {
        return String.format("%s: %s for target audience %s. Budget: $%.2f, Potential ROI: $%.2f", 
                             name, description, targetAudience, budget, potentialROI);
    }
}

class MarketingStrategyRepository {
    private Map<String, MarketingStrategy> strategies = new HashMap<>();

    public String addStrategy(String name, String description, String targetAudience, double budget, double potentialROI) {
        if (strategies.containsKey(name)) {
            return "Strategy with this name already exists.";
        }
        strategies.put(name, new MarketingStrategy(name, description, targetAudience, budget, potentialROI));
        return "Strategy Added Successfully.";
    }

    public String fetchStrategy(String name) {
        MarketingStrategy strategy = strategies.get(name);
        if (strategy == null) {
            return "Strategy not found.";
        }
        return strategy.toString();
    }

    public String updateStrategy(String name, String description, String targetAudience, double budget, double potentialROI) {
        MarketingStrategy strategy = strategies.get(name);
        if (strategy == null) {
            return "Strategy not found.";
        }
        strategy.updateDetails(description, targetAudience, budget, potentialROI);
        return "Strategy Updated Successfully.";
    }

    public String deleteStrategy(String name) {
        if (strategies.remove(name) != null) {
            return "Strategy Deleted Successfully.";
        }
        return "Strategy not found.";
    }

    public String listStrategiesByBudget(double minBudget, double maxBudget) {
        StringBuilder result = new StringBuilder();
        for (MarketingStrategy strategy : strategies.values()) {
            if (strategy.getBudget() >= minBudget && strategy.getBudget() <= maxBudget) {
                result.append(strategy.toString()).append("\n");
            }
        }
        if (result.length() == 0) {
            return "No strategies found within the specified budget range.";
        }
        return result.toString();
    }
}
