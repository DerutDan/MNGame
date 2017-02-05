package MNClient.ClientInterface.Menu;

import MNClient.StatVar;
import io.netty.channel.Channel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Danila on 04.02.17.
 */
public class CancelButton extends JButton {
    FindGameButton fg;
    CancelButton(FindGameButton fg,Channel ch) {
        setBounds((StatVar.menuFrameWidth - StatVar.menuButtonWidth)/2,0, StatVar.menuButtonWidth,
                StatVar.menuButtonHeight);
        setText("Cancel");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ch.close();
                    fg.setVisible(true);
                    setVisible(false);
            }
        });
        setVisible(false);
    }
}
