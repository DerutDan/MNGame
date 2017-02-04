package MNClient.ClientInterface.Menu;

import MNClient.StatVar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Danila on 04.02.17.
 */
public class CancelButton extends JButton {
    CancelButton() {
        setBounds((StatVar.menuFrameWidth - StatVar.menuButtonWidth)/2,0, StatVar.menuButtonWidth,
                StatVar.menuButtonHeight);
        setText("Cancel");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GSMenu.findGame.shutDown();
                    GSMenu.findGame.setVisible(true);
                    setVisible(false);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
            }
        });
        setVisible(false);
    }
}
