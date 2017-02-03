import io.netty.channel.Channel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Danila on 03.02.17.
 */
public class HandPacket extends MNSPacket implements Serializable {
    ArrayList<Monster> hand;
    HandPacket(ArrayList<Monster> hand)
    {
        this.hand = hand;
    }
    @Override
    public void send(Channel buffer) {
        buffer.writeAndFlush(hand);
    }

    @Override
    public void get(Channel ch) {

    }

    @Override
    public int getPacketClass() {
        return 2;
    }
}
