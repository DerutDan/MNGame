package MNGame;

import MNGame.MNSPacket.DisconnectPacket;
import MNGame.MNSPacket.MNSPacket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.PriorityQueue;


public class MNClientHandler extends ChannelInboundHandlerAdapter {
    PriorityQueue<MNSPacket> queue;
    MNClientHandler(PriorityQueue<MNSPacket> queue)
    {
        this.queue = queue;
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof MNSPacket) {
            queue.add((MNSPacket)msg);
        }
        else {
            System.out.println("Non packet msg recieved!");
        }

    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        queue.add(new DisconnectPacket("Connection lost"));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
