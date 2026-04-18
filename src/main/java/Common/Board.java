package Common;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int row;
    private  int col;

    private List<List<Symbol>> grid;

    public Board(int row, int col){
        this.row = row;
        this.col = col;
        grid = new ArrayList<>();

        for (int i=0; i<row; i++){
            List<Symbol> curr = new ArrayList<>();
            for (int j =0; j <col ;j++){
                curr.add(new Symbol('_'));
            }
            grid.add(curr);
        }
    }

    public boolean isEmptyCell(int row, int col){
        if (row<0 || row >= this.row || col <0 || col>=this.col){
            return false;
        }
        else {
            return grid.get(row).get(col).getS()=='_';
        }
    }

    public boolean placeMark(int row, int col, Symbol s){
        if (row<0 || row >= this.row || col <0 || col>=this.col){
            return false;
        }
        else if (isEmptyCell(row, col)){
            grid.get(row).set(col, s);
            return true;
        }
        else {
            return false;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public List<List<Symbol>> getGrid() {
        return grid;
    }

    public Symbol getCell(int r, int c){
        if (row<0 || row >= this.row || col <0 || col>=this.col){
            return null;
        }
        return grid.get(row).get(col);
    }

    void print(){
        for (int i=0; i <row; i++){
            for(int j=0; j  <col; j++){
                System.out.print(grid.get(i).get(j).getS());
            }
            System.out.println();
        }
        System.out.println();
    }
}
