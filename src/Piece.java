public interface Piece {
    void setWhite(boolean white);
    boolean isWhite();
    boolean validateMove(int row,int col);
    String pieceType();
}
