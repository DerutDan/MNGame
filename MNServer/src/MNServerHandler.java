import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.PriorityQueue;


public class MNServerHandler extends ChannelInboundHandlerAdapter {

    int id;
    int player;
    GameSession gameS;
    PriorityQueue<MNSPacket> pQue;



    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        gameS =  MNServer.sessions.get(MNServer.sessions.size()-1);
        player = gameS.aquire(ctx.channel());
        if(player == 0) {
            gameS = new GameSession();
            player  = gameS.aquire(ctx.channel());
            MNServer.sessions.add(gameS);
            id = MNServer.sessions.indexOf(gameS);
        }
        pQue = MNServer.packetQueue;
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

       gameS.disconnected(player);
       ctx.close();
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof MNSPacket)
        {
            MNSPacket packet = (MNSPacket)msg;
            packet.boundSession(id);
            pQue.add(packet);
        }

    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
