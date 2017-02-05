package MNClient.MNSPacket;

import io.netty.channel.Channel;

/**
 * Created by Danila on 03.02.17.
 */
public class StartTurnPacket extends MNSPacket {
    Channel ch;

    @Override
    public Object get() {
        return null;
    }

    @Override
    public void setPacketClass() {
        type = 7;
    }
}
