package interfaces;

import Common.Board;
import Common.Symbol;

public interface Strategy {
    public boolean isValidMove(Board board, int row , int col);
    public boolean checkWin(Board board, Symbol s);
    public boolean checkDraw(Board board);
}
