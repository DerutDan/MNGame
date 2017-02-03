package MNServer.MNSPacket;

import io.netty.channel.Channel;

/**
 * Created by Danila on 03.02.17.
 */
public class StartGamePacket extends MNSPacket {
    @Override
    public Object get(Channel ch) {
        return null;
    }

    @Override
    public void setPacketClass() {
        type = 9;
    }
}
