public class ChessBoard {
    private static ChessBoard instance = null;
    private Piece[][] board;

    private ChessBoard(){
        board= new Piece[8][8];
        initializeBoard();
    }

    public static ChessBoard getInstance(){
        if(instance == null){
            instance= new ChessBoard();
        }
        return instance;
    }

    public void initializeBoard(){
        //white
        board[0][0] = new Rook(true);
        board[0][1] = new Knight(true);
        board[0][2] = new Bishop(true);
        board[0][3] = new Queen(true);
        board[0][4] = new King(true);
        board[0][5] = new Bishop(true);
        board[0][6] = new Knight(true);
        board[0][7] = new Rook(true);

        board[1][0] = new Pawn(true);
        board[1][1] = new Pawn(true);
        board[1][2] = new Pawn(true);
        board[1][3] = new Pawn(true);
        board[1][4] = new Pawn(true);
        board[1][5] = new Pawn(true);
        board[1][6] = new Pawn(true);
        board[1][7] = new Pawn(true);

        //black
        board[7][0] = new Rook(false);
        board[7][1] = new Knight(false);
        board[7][2] = new Bishop(false);
        board[7][3] = new Queen(false);
        board[7][4] = new King(false);
        board[7][5] = new Bishop(false);
        board[7][6] = new Knight(false);
        board[7][7] = new Rook(false);

        board[6][0] = new Pawn(false);
        board[6][1] = new Pawn(false);
        board[6][2] = new Pawn(false);
        board[6][3] = new Pawn(false);
        board[6][4] = new Pawn(false);
        board[6][5] = new Pawn(false);
        board[6][6] = new Pawn(false);
        board[6][7] = new Pawn(false);
    }

    public void movePiece(int fromRow,int fromCol, int toRow, int toCol){
        if(board[fromRow][fromCol] == null){
            int row = fromRow+1;  //add 1 to fromRow to because its zero based
            System.out.println("the spot " + (char)(fromCol+'A') + row + " is Empty!");
            return;
        }

        board[fromRow][fromCol].validateMove(toRow,toCol);

        if(board[toRow][toCol] != null){
            String piece = board[toRow][toCol].pieceType();
            String color = board[toRow][toCol].isWhite()?"white":"black";
            System.out.println("a " + color + " " + piece + " has been killed!");
        }

        board[toRow][toCol] = board[fromRow][fromCol];
        System.out.println(board[fromRow][fromCol].pieceType() + " moved successfully!");
        board[fromRow][fromCol] = null;

        if((toRow == 7 || toRow == 0) && board[toRow][toCol].pieceType() == "Pawn"){
            promotion(toRow,toCol);
        }
    }

    public boolean isBlackCheckMated(){
        return false;
    }

    public boolean isWhiteCheckMated(){
        return false;
    }

    public boolean isStaleMate(){
        return false;
    }

    public void promotion(int row, int col){
        board[row][col] = new Queen(board[row][col].isWhite());
        System.out.println("A pawn has been promoted to Queen!");
    }
}
