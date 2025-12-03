public class Problem3 extends ConsoleProgram {
    @Override
    public void run() {
        String[] players = {"Ana", "Ben", "Ming", "Hermione"};
        int[] scores = {14, 22, 18, 31};

        for (int i = 0; i <= players.length - 1; i++){
            print(players[i]);
            for(int g = 0; g<10 - players[i].length(); g++){
                print(" "); 
            }
            print(": "+scores[i]);
            println();
        }
    }   
}

