public class Bishop implements Piece {
    private boolean white;

    public Bishop(boolean white){
        this.white=white;
    }

    public void setWhite(boolean white) {
        this.white=white;
    }

    public boolean isWhite() {
        return white;
    }

    public boolean validateMove(int row, int col){return true;}
    public String pieceType(){
        return "Bishop";
    }
}
