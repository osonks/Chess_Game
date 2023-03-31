public class ChessGame {
    private boolean whiteTurn=true;
    private String winner;
    private Player whitePlayer;
    private Player blackPlayer;
    private ChessBoard board;

    public ChessGame(String player1, String player2){
        board = ChessBoard.getInstance();
        whitePlayer=new Player(player1,true);
        blackPlayer=new Player(player2,false);
        winner=null;
    }
    public boolean isWhiteTurn(){ return whiteTurn; }

    public void playWhite(String move){

        if(isValidString(move)){
            whiteTurn=false;
            System.out.println("now its "+blackPlayer.getName()+"'s turn");
        }
        else System.out.println("please enter a move in correct format!");
    }

    public void playBlack(String move){
        if(isValidString(move)){
            whiteTurn=true;
            System.out.println("now its "+whitePlayer.getName()+"'s turn");
        }
        else System.out.println("please enter a move in correct format!");
    }

    public boolean isDone(){
        if(board.isBlackCheckMated()){
            winner = whitePlayer.getName();
            return true;
        }

        else if(board.isWhiteCheckMated()){
            winner = blackPlayer.getName();
            return true;
        }

        else if(board.isStaleMate()){
            System.out.println("its a tie!");
            winner = whitePlayer.getName() + " and " + blackPlayer.getName();
            return true;
        }
        return false;
    }

    public void printWinnerName(){ System.out.println("Congrats! "+ winner + " is the winner\nGame has ended..."); }

    public boolean isValidString(String move){

        String[] parts = move.split(" ");
        if(parts.length != 3 )return false;
        if(!parts[0].equals("move") && !parts[0].equals("MOVE"))return false;
        for(int i=1;i<parts.length;i++){
            if(parts[i].length()!=2){ return false; }
            if(!Character.isLetter(parts[i].charAt(0)) || parts[i].charAt(0) > 'H')return false;
            if(!Character.isDigit(parts[i].charAt(1)) || parts[i].charAt(1) > '8')return false;
        }

        int fromRow, fromCol, toRow, toCol;
        fromCol=parts[1].charAt(0)-'A';
        fromRow=parts[1].charAt(1)-'1';
        toCol = parts[2].charAt(0)-'A';
        toRow = parts[2].charAt(1)-'1';
        board.movePiece(fromRow,fromCol,toRow,toCol);

        return true;
    }

}
