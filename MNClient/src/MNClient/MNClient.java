package MNClient;

import MNClient.ClientInterface.GameFrame.GameFrame;
import MNClient.ClientInterface.Menu.GSMenu;
import MNClient.MNSPacket.MNSPacket;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.PriorityQueue;

public class MNClient {

    boolean isGameOn = false;
    Thread game;
    PriorityQueue<MNSPacket> queue = new PriorityQueue<>();
    GSMenu menu;
    final int port = 4444;
    final String address = "localhost";
    Channel channel;
    public void main(String[] args) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.handler(new MNClientInitializer());
        menu = new GSMenu(address,port,b,channel);
    }
    public void shift()
    {
        menu.setVisible(false);
        GameFrame gf = new GameFrame(channel);
    }
}
