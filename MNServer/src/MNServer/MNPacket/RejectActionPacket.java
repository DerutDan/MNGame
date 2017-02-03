package MNServer.MNPacket;

import io.netty.channel.Channel;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class RejectActionPacket extends MNSPacket implements Serializable {
    String reason;
    public RejectActionPacket(String reason)
    {
        this.reason = "Action rejected:" + reason;
    }
    @Override
    public void send(Channel ch) {
        ch.writeAndFlush(reason);
    }

    @Override
    public void get(Channel ch) {

    }

    @Override
    public int getPacketClass() {
        return 4;
    }
}
