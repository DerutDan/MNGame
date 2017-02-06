package MNGame.ClientInterface.GameFrame;

import MNGame.GameCards.Hero;
import MNGame.GameCards.Monster;
import MNGame.StatVar;
import io.netty.channel.Channel;

import javax.swing.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    Channel channel;
    LogLabel log;
    Hero hero;
    ArrayList<Monster> hand; //todo
    ArrayList<Monster> myBoard;
    ArrayList<Monster> enemyBoard;
    JPanel panel;


    public GameFrame(Channel channel)
    {
        this.channel = channel;
        hand = new ArrayList<>();
        myBoard = new ArrayList<>();
        enemyBoard = new ArrayList<>();
        setBounds(0,0, StatVar.gameFrameWidth,StatVar.gameFrameHeight);

        log = new LogLabel();

        panel = new JPanel();
        panel.setLayout(null);

        panel.add(log);

        add(panel);
        setVisible(true);
        setFocusable(true);
    }
    public void upDateLog(String s,boolean rejected)
    {
        log.update(s,rejected);
    }
    public void upDateHero(Hero hero)
    {
        this.hero = hero;
        panel.repaint();
    }
    public void takeCard(Monster card)//todo
    {
        hand.add(card);
        panel.repaint();
    }
    public void monsterHit(Monster m,int index,boolean isMine)
    {
        if(isMine) myBoard.add(index,m);
        else enemyBoard.add(index,m);
        panel.repaint();
    }
    public void monsterAdded(Monster m,boolean isMine)
    {
        if(isMine)
            myBoard.add(m);
        else
            enemyBoard.add(m);
        panel.repaint();
    }
    public void startTurn()
    {
        log.update("Your turn", false);
    }
    public void gameStarted()
    {
        log.update("Game started!",false);
    }
}
