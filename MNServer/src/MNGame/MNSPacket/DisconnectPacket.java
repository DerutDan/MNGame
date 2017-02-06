package MNGame.MNSPacket;

import io.netty.channel.Channel;

/**
 * Created by Danila on 03.02.17.
 */
public class DisconnectPacket extends MNSPacket {
    String reason;
    public DisconnectPacket(String reason)
    {
        this.reason = reason;
    }
    @Override
    public  String get(Channel ch) {
        return reason;
    }

    @Override
    public void setPacketClass() {
        type = 10;
    }
}
