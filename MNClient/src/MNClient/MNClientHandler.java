package MNClient;

import MNClient.MNSPacket.MNSPacket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.PriorityQueue;


public class MNClientHandler extends ChannelInboundHandlerAdapter {
    PriorityQueue<MNSPacket> queue = MNClient.queue;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof MNSPacket) {
            if (MNClient.isGameOn) {
                queue.add((MNSPacket) msg);
            }
            else {
                if(((MNSPacket)msg).getT() == 10)
                {
                    MNClient.isGameOn = true;
                    MNClient.game.start();
                }
            }
        }
        else {
            System.err.println("Non packet msg recieved!");
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
