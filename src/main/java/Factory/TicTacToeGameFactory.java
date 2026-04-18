package Factory;

import Common.TicTacToeGame;
import Strategies.StandardRules;

public class TicTacToeGameFactory {
    public static TicTacToeGame createGame(int size){

        // we are using 3 as of now
        TicTacToeGame newGame = new TicTacToeGame(size, new StandardRules());
        return newGame;
    }
}
