package Common;

import Factory.TicTacToeGameFactory;
import Oberser.ConsoleNotifier;
import Strategies.HumanPlayer;
import interfaces.IObserver;

import java.util.Scanner;


public class PlayingGame {

    static Scanner myobj = new Scanner((System.in));
    public static void m(){

        System.out.println("----TICTACTOE----");

        System.out.println("What could be the baord size ?");
        int boardsize = Integer.parseInt(myobj.nextLine());

        TicTacToeGame ticTacToeGame = TicTacToeGameFactory.createGame(boardsize);

        IObserver observer = new ConsoleNotifier();
        ticTacToeGame.addObserver(observer);

        HumanPlayer p1 = new HumanPlayer(1,"varinder", new Symbol('X'));
        HumanPlayer p2 = new HumanPlayer(2,"shubhangi", new Symbol('O'));

        ticTacToeGame.addPlayer(p1);
        ticTacToeGame.addPlayer(p2);



        ticTacToeGame.play();


    }

}
