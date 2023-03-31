import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ChessGame game = new ChessGame("fahed","ahmad");
        Scanner sc = new Scanner(System.in);

        while(!game.isDone()){
            System.out.println("\nEnter a move: ");
            String move = sc.nextLine();
            if(game.isWhiteTurn())
                game.playWhite(move);
            else
                game.playBlack(move);
        }
        game.printWinnerName();
    }
}
