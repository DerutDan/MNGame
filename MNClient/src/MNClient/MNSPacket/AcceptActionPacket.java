package MNClient.MNSPacket;

import io.netty.channel.Channel;

/**
 * Created by Danila on 03.02.17.
 */
public class AcceptActionPacket extends MNSPacket {
    @Override
    public Object get(Channel ch) {
        return null;
    }

    @Override
    public void setPacketClass() {
        type = 8;
    }
}
