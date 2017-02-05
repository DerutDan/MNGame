package MNClient.ClientInterface.Menu;

import MNClient.StatVar;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;

import javax.swing.*;



public class GSMenu extends JFrame {
    static CancelButton cancel;
    static FindGameButton findGame;
    EventLoopGroup workerGroup;
    public GSMenu(String address,int port,Bootstrap b, Channel channel){

        cancel = new CancelButton(findGame,channel);

        findGame = new FindGameButton(address,port,channel,b,cancel);



        setBounds(0,0, StatVar.menuFrameWidth, StatVar.menuFrameHeight);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(findGame);
        panel.add(cancel);

        GSMenu.cancel.setVisible(true);
        setVisible(false);
        add(panel);
        setVisible(true);



    }

}
