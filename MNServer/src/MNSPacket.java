
import io.netty.channel.Channel;

import java.io.Serializable;


/**
 * Created by Danila on 03.02.17.
 */

public abstract class MNSPacket implements Serializable {
    int sessionId;
    public void boundSession(int id)
    {
        sessionId = id;
    }

    public void write(Channel ch)
    {
        ch.write(getPacketClass());
        send(ch);

    }
    public int read(Channel ch)
    {
        int id = getPacketClass();
        get(ch);
        return id;
    }
    public int getSessionId() {
        return sessionId;
    }
    public abstract void send(Channel ch);
    public abstract void get(Channel ch);
    public abstract int getPacketClass();//Hero - 1; Hand - 2; TakeCard - 3; RejectAction - 4; MonsterHit - 5; MonsterAdded - 6;
    //7 - Start turn;
}
