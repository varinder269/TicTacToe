package Strategies;

import Common.Symbol;
import interfaces.Player;

public class HumanPlayer implements Player {
    int id;
    String name;
    int score;
    Symbol s;

    public HumanPlayer(int id, String name, Symbol s) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.s = s;
    }

    @Override
    public Symbol getSymbol() {
        return s;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public Symbol getS() {
        return s;
    }

    public void incScore(){
        this.score++;
    }


    public int getScore() {
        return score;
    }
}
