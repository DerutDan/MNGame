package MNClient;

import MNClient.MNSPacket.MNSPacket;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.PriorityQueue;

public class MNClient {
    static final int port = 4444;
    static final String address = "localhost";
    public static boolean isGameOn = false;
    public static Thread game;
    public static PriorityQueue<MNSPacket> queue = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new MNClientInitializer());
            Channel f = b.connect(address, port).sync().channel();
            f.closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
