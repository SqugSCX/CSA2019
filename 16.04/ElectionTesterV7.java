public class ElectionTesterV7 {
    public static void main(String[] args)  {
        Candidate[] candidates = new Candidate[5];
        candidates[0] = new Candidate("Lucy Robertson", 6000);
        candidates[1] = new Candidate("Marie Grace", 2400);
        candidates[2] = new Candidate("Boyce Ronk", 1800);
        candidates[3] = new Candidate("Andrea Sienfeld", 3200);
        candidates[4] = new Candidate("Catalina Traverso", 2100);
        candidateData(candidates);
        printTable(candidates);
        nameChange(candidates, "Marie Grace", "Maurice Hippo");
        voteChange(candidates, "Lucy Robertson", 6001);
        nameVoteChange(candidates, "Boyce Ronk", "Bruce Ruperts", 1801);
        //
        System.out.println("\n\nBefore Inserting New: ");
        printTable(candidates);

        // Note that for each position that goes into the method, it is based on the VISUAL position, not index.
        // For example, you look at the list and want to delete whoever is in the second spot, you would use
        // the number 2, not the index position, which is 1.

        System.out.println("\n\nAfter inserting 'New Candidate' using position:");
        candidates = insertCandidate(candidates, 2, "New Candidate", 2500);
        printTable(candidates);

        System.out.println("\n\nAfter inserting 'Another Candidate' using name:");
        candidates = insertCandidate(candidates, "Catalina Traverso", "Another Candidate", 1800);
        printTable(candidates);

        System.out.println("\n\nAfter deleting whichever candidate is in position 3:");
        candidates = deleteCandidate(candidates, 3);
        printTable(candidates);

        System.out.println("\n\nAfter deleting 'Catalina Traverso' :");
        candidates = deleteCandidate(candidates, "Catalina Traverso");
        printTable(candidates);
    }

    public static void candidateData(Candidate[] candidates)   {
        System.out.println("Raw Election Data: \n");
        for(int i = 0; i < candidates.length; i++)  {
            System.out.println(candidates[i].toString());
        }
        System.out.println("\n\n");
    }

    public static int totalVotes(Candidate[] candidates)    {
        int totalVotes = 0;
        for(int i = 0; i < candidates.length; i++)  {
            totalVotes += candidates[i].getVotes();
        }
        return totalVotes;
    }

    public static void nameChange(Candidate[] candidates, String curName, String newName)    {
        for(int i = 0; i < candidates.length; i++)  {
            String tempName;
            tempName = candidates[i].getName();
            if(tempName.equals(curName))    {
                candidates[i].setName(newName);
            }
        }
    }

    public static void voteChange(Candidate[] candidates, String curName, int newVotes)    {
        for(int i = 0; i < candidates.length; i++)  {
            String tempName;
            tempName = candidates[i].getName();
            if(tempName.equals(curName))    {
                candidates[i].setVotes(newVotes);
            }
        }
    }

    public static void nameVoteChange(Candidate[] candidates, String curName, String newName, int newVotes)    {
        for(int i = 0; i < candidates.length; i++)  {
            String tempName;
            tempName = candidates[i].getName();
            if(tempName.equals(curName))    {
                candidates[i].setName(newName);
                candidates[i].setVotes(newVotes);
            }
        }
    }

    public static Candidate[] insertCandidate(Candidate[] candidates, int pos, String newCand, int votes) {
        Candidate[] newTempList = new Candidate[candidates.length + 1];
        String name = newCand;
        int insPos = pos - 1;
        for(int i = 0; i < insPos; i++) {
            newTempList[i] = candidates[i];
        }
        Candidate insertedCandidate = new Candidate(name, votes);
        newTempList[insPos] = insertedCandidate;
        for(int i = pos; i < newTempList.length; i++)   {
            newTempList[i] = candidates[i-1];
        }
        return newTempList;
    }

    public static Candidate[] insertCandidate(Candidate[] candidates, String afterCand, String newCand, int votes) {
        Candidate[] newTempList = new Candidate[candidates.length + 1];
        String name = newCand;
        int pos = 0;
        for(int i = 0; i < candidates.length; i++)  {
            String tempName = candidates[i].getName();
            if(tempName.equals(afterCand))  {
                pos = i + 1;
            }
        }
        int insPos = pos - 1;
        for(int i = 0; i < insPos; i++) {
            newTempList[i] = candidates[i];
        }
        Candidate insertedCandidate = new Candidate(name, votes);
        newTempList[insPos] = insertedCandidate;
        for(int i = pos; i < newTempList.length; i++)   {
            newTempList[i] = candidates[i-1];
        }
        return newTempList;
    }

    public static Candidate[] deleteCandidate(Candidate[] candidates, int pos) {
        Candidate[] newTempList = new Candidate[candidates.length];
        int delPos = pos - 1;
        for(int i = 0; i < delPos; i++) {
            newTempList[i] = candidates[i];
        }
        for(int i = pos; i < newTempList.length; i++)   {
            newTempList[i-1] = candidates[i];
        }

        Candidate[] finalTempList = new Candidate[newTempList.length - 1];
        for(int i = 0; i < finalTempList.length; i++)   {
            finalTempList[i] = newTempList[i];
        }
        return finalTempList;
    }

    public static Candidate[] deleteCandidate(Candidate[] candidates, String name) {
        Candidate[] newTempList = new Candidate[candidates.length];
        int pos = 0;
        for(int i = 0; i < newTempList.length; i++) {
            String tempName = candidates[i].getName();
            if(tempName.equals(name))   {
                pos = i  +1;
            }
        }
        int delPos = pos - 1;
        for(int i = 0; i < delPos; i++) {
            newTempList[i] = candidates[i];
        }
        for(int i = pos; i < newTempList.length; i++)   {
            newTempList[i-1] = candidates[i];
        }

        Candidate[] finalTempList = new Candidate[newTempList.length - 1];
        for(int i = 0; i < finalTempList.length; i++)   {
            finalTempList[i] = newTempList[i];
        }
        return finalTempList;
    }


    public static void printTable(Candidate[] candidates) {
        System.out.println("Election Results: \n");
        System.out.printf("%-20s", "Candidate");
        System.out.printf("%-20s", "Votes Recieved");
        System.out.printf("%s", "% of Total Votes\n");
        System.out.println("------------------------------------------------------");

        for(int i = 0; i < candidates.length; i++)  {
            System.out.printf("%-25s",candidates[i].getName());
            System.out.printf("%-18s",candidates[i].getVotes());
            System.out.printf("%-2.5s",((double)candidates[i].getVotes() / (double)totalVotes(candidates)) * 100);
            System.out.println("");
        }
        System.out.println("Total number of votes in this election: " + totalVotes(candidates));
    }
}
