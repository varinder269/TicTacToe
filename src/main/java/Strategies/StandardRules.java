package Strategies;

import Common.Board;
import Common.Symbol;
import interfaces.Strategy;

public class StandardRules implements Strategy {
    @Override
    public boolean isValidMove(Board board , int row, int col) {
        return board.isEmptyCell(row, col);
    }

    @Override
    public boolean checkWin(Board board, Symbol s) {

        for (int i=0; i <board.getRow(); i++){
            boolean win = true;

            for(int j=0; j <board.getCol(); j++){
                if (board.getGrid().get(i).get(j).getS()!=s.getS()){
                    win = false;
                    break;
                }
            }
            if (win){
                return win;
            }
        }

        for (int i=0; i <board.getRow(); i++){
            boolean win = true;

            for(int j=0; j <board.getCol(); j++){
                if (board.getGrid().get(j).get(i).getS()!=s.getS()){
                    win = false;
                    break;
                }
            }
            if (win){
                return win;
            }
        }
        boolean win = true;
        for (int i=0; i <board.getRow(); i++){
            if (board.getGrid().get(i).get(i).getS()!=s.getS()){
                win = false;
                break;
            }
        }

        if (win) return win;
        win = true;

        for (int i=0; i <board.getRow(); i++){
            if (board.getGrid().get(i).get(board.getCol()-1-i).getS()!=s.getS()){
                win = false;
                break;
            }
        }
        return win;
    }

    @Override
    public boolean checkDraw(Board board) {
        for (int i=0; i <board.getRow(); i++) {
            for (int j = 0; j < board.getCol(); j++) {
                if (board.getGrid().get(i).get(j).getS()== '_') {
                    return false;
                }
            }
        }
        return true;
    }
}
