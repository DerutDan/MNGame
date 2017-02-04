package MNClient.ClientInterface.GameFrame;

import io.netty.channel.Channel;

import javax.swing.*;

/**
 * Created by Danila on 04.02.17.
 */
public class GameFrame extends JFrame {
    Channel channel;
    public GameFrame(Channel chanel)
    {
        this.channel = channel;

    }
}
