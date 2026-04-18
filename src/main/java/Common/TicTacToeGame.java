package Common;

import interfaces.Game;
import interfaces.IObserver;
import interfaces.Player;
import interfaces.Strategy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static Common.PlayingGame.myobj;

public class TicTacToeGame implements Game {
    private Board b;
    public boolean gameover = false;
    Deque<Player> list = new ArrayDeque<>();
    List<IObserver> observers = new ArrayList<>();
    private Strategy rules;


    public TicTacToeGame(int size, Strategy rules) {
        this.b = new Board(size, size);
        this.rules = rules;
    }

    public void setRules(Strategy rules) {
        this.rules = rules;
    }

    public void addPlayer(Player p) {
        list.add(p);
    }

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void notifyAll(String msg) {
        for (IObserver observer : observers) {
            observer.update(msg);
        }
        System.out.println("notified all");
    }

    public void play() {

        if (list.size() < 2) {
            System.out.println("need 2 plaers atleast");
            return;
        }
        Player current = list.getFirst();

        System.out.println("PLayer 1 " + list.getFirst().getName() + " " + list.getFirst().getSymbol().getS());
        System.out.println("player 2 " + list.getLast().getName() + " " + list.getLast().getSymbol().getS());

        do {

            b.print();
            current = list.getFirst();
            notifyAll(current.getName() + ". PLEASE add row and column you want to place your symbol " + current.getSymbol().getS());
            int row = myobj.nextInt();
            int col = myobj.nextInt();

            if (b.isEmptyCell(row, col)) {
                b.placeMark(row, col, current.getSymbol());
                if (rules.checkWin(b, current.getSymbol())) {
                    this.gameover = true;
                    notifyAll(current.getName() + " WINS!!! with symbol " + current.getSymbol().getS());
                } else if (rules.checkDraw(b)) {
                    notifyAll("Game draw");
                    this.gameover = true;
                } else {
                    list.add(list.pop());
                }
            } else {
                notifyAll("try again");
            }
        } while (!this.gameover);
    }


}
