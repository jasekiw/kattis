import java.util.Scanner;

public class PopularVote {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int testCases = inputScanner.nextInt();
        for(int testCase = 0; testCase < testCases; testCase++) {
            int numLines = inputScanner.nextInt();
            int totalVotes = 0;
            int highestVotingCandidate = 0;
            int highestVote = 0;
            boolean noWinner = false;
            for(int i = 1; i <= numLines; i++){
                int numVotes = inputScanner.nextInt();
                if(numVotes > highestVote) {
                    noWinner = false;
                    highestVote = numVotes;
                    highestVotingCandidate = i;
                }
                else if(highestVote == numVotes)
                    noWinner = true;
                totalVotes += numVotes;
            }
            if(noWinner)
                System.out.println("no winner");
            else if(highestVote > ((double) totalVotes / 2.0))
                System.out.println("majority winner " + highestVotingCandidate);
            else
                System.out.println("minority winner " + highestVotingCandidate);
        }

    }
}
