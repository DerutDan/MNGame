package MNGame.ClientInterface.GameFrame;

import MNGame.StatVar;

import javax.swing.*;
import java.awt.*;


public class LogLabel extends JLabel {

    LogLabel()
    {
        setBounds(StatVar.gameFrameWidth-StatVar.logLabelWidth,StatVar.gameFrameHeight - StatVar.gameFrameHeight,
                StatVar.gameFrameWidth,StatVar.gameFrameHeight);
        setVisible(true);
    }
    public void update(String s, boolean rejected)
    {
        if(rejected) setBackground(Color.RED);
        else setBackground(Color.white);
        setText(s);
        this.repaint();
    }
}
