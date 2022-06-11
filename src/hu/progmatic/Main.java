package hu.progmatic;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            List<VBmatch> vbMatches = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("matches_all.csv"))) {
                String line;

                reader.readLine();

                while ((line = reader.readLine()) != null) {
                    VBmatch vbMatch = new VBmatch(line);
                    vbMatches.add(vbMatch);
                }
            }
            System.out.println("Number of matches:" + vbMatches.size());

            System.out.println("Year of the worldcup:");
            int chosedYear = Integer.parseInt(scanner.nextLine());

            List<VBmatch> matchesByYear = new ArrayList<>();
            for(VBmatch vbMatch : vbMatches) {
                if (vbMatch.getYear() == chosedYear) {
                    matchesByYear.add(vbMatch);
                }
            }
            try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("selected.csv")))) {
                for(VBmatch vbMatch : matchesByYear) {
                    writer.println(vbMatch.getStage() + ";" + vbMatch.getDate() + ";" + vbMatch.getTeam_a() + ";" + vbMatch.getTeam_b() + ";" + vbMatch.getGoals_a() + ";" + vbMatch.getGoals_b() + ";" + vbMatch.getPenalties_a() + ";" + vbMatch.getPenalties_b());
                }

            }
            System.out.println("2. Maximum goal difference:" + maximumGoalsDifference(vbMatches, chosedYear));

            System.out.println("3. The player has won:" + wonnedMatchesSummary(vbMatches, chosedYear));
            System.out.println(goalsSummaryByStagesAndYear(vbMatches, "Group A", chosedYear));
            System.out.println("Total goals by stage:");

            Map<String, Integer> totalGoalsByStage = new TreeMap<>();
            for(VBmatch vbMatch : vbMatches){
                int count = totalGoalsByStage.getOrDefault(vbMatch.getStage(), 0);
                totalGoalsByStage.put(vbMatch.getStage(), count + 1);

            }
            for (String stages : totalGoalsByStage.keySet()) {
                System.out.println(stages + ": " + totalGoalsByStage.get(stages));
            }

            } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int maximumGoalsDifference(List<VBmatch> vbMatches, int year){
        int maxDifference = Integer.MIN_VALUE;
        for(VBmatch vbMatch : vbMatches){
            if(vbMatch.getYear() == year && vbMatch.getDifference() > maxDifference){
                maxDifference = vbMatch.getDifference();
            }
        }
        return maxDifference;
    }
    public static int wonnedMatchesSummary(List<VBmatch> vbMatches, int year){
        int sum = 0;
        for(VBmatch vbMatch : vbMatches){
            if(vbMatch.getYear() == year && vbMatch.getGoals_a() > vbMatch.getGoals_b()){
                sum++;
            }
        }
        return sum;
    }
    public static int goalsSummaryByStagesAndYear(List<VBmatch> vbMatches, String stage, int year){
        int sum = 0;
        for(VBmatch vbMatch : vbMatches){
            if(vbMatch.getStage().equals(stage) && vbMatch.getYear() == year){
                sum += (vbMatch.getGoals_a() + vbMatch.getGoals_b());
            }
        }
        return sum;
    }
}
