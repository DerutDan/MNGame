package MNServer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by Danila on 02.02.17.
 */
public class MNServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
        .addLast("encoder", new ObjectEncoder())
        .addLast("decoder", new StringDecoder())
        .addLast("handler", new MNServerHandler());
    }
}
