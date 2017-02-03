package MNServer.MNSPacket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.io.Serializable;


/**
 * Created by Danila on 03.02.17.
 */

public abstract class MNSPacket implements Serializable {
    int sessionId;
    int type;
    public void boundSession(int id)
    {
        sessionId = id;
    }

    public ChannelFuture write(Channel ch)
    {
        return ch.writeAndFlush(this);
    }

    public int getSessionId() {
        return sessionId;
    }
    public int getT() { return type; }
    public abstract Object get(Channel ch);
    public abstract void setPacketClass();//Hero - 1; Hand - 2; TakeCard - 3; RejectAction - 4; MonsterHit - 5; MonsterAdded - 6;
    //7 - Start turn; 8 - AcceptAction; 9 - StartGamePacket; 10 - Disconnect;
}
