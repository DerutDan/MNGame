package MNClient;

import MNClient.MNSPacket.MNSPacket;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.PriorityQueue;


public class MNClientInitializer extends ChannelInitializer<SocketChannel> {
    PriorityQueue<MNSPacket> queue;
    MNClientInitializer(PriorityQueue que)
    {
        this.queue = queue;
    }
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast("encoder", new ObjectDecoder(ClassResolvers
                .cacheDisabled(null)));
        pipeline.addLast("decoder", new StringEncoder());
        pipeline.addLast("handler", new MNClientHandler(queue));


    }
}
