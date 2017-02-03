import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Danila on 02.02.17.
 */
public class MNServer {
    final int port;
    static final ArrayList<GameSession> sessions = new ArrayList<>();
    static final PriorityQueue<MNSPacket> packetQueue = new PriorityQueue<>();
    MNServer(int port) {
       this.port = port;
    }
    public void run()
    {
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup io = new NioEventLoopGroup(2);
        try {
            ServerBootstrap server = new ServerBootstrap()
                    .group(boss, io)
                    .channel(NioServerSocketChannel.class)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new MNServerInitializer());
            sessions.add(new GameSession());
            StatVar.initMonsterDeck();
            server.bind(port).sync().channel().close().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally
        {
            io.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }
    public static void main(String args[])
    {
        MNServer serv = new MNServer(4444);
        serv.run();
    }
}
