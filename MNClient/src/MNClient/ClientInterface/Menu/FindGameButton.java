package MNClient.ClientInterface.Menu;

import MNClient.MNClientInitializer;
import MNClient.StatVar;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Created by Danila on 04.02.17.
 */
public class FindGameButton extends JButton {
    Channel channel;
    Bootstrap b;
    FindGameButton(String address, int port, Channel _channel,Bootstrap _b,CancelButton cancel)
    {
        this.channel = _channel;
        this.b = _b;
        setBounds((StatVar.menuFrameWidth - StatVar.menuButtonWidth)/2,0
        ,StatVar.menuButtonWidth,StatVar.menuButtonHeight);
        setText("Find game");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    channel = b.connect(address, port).sync().channel();
                    cancel.setVisible(true);
                    setVisible(false);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
            }
        });
        setVisible(true);
    }


}
