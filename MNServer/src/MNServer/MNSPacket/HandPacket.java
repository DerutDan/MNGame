package MNServer.MNSPacket;

import MNServer.GameCards.Monster;
import io.netty.channel.Channel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Danila on 03.02.17.
 */
public class HandPacket extends MNSPacket implements Serializable {
    ArrayList<Monster> hand;
    public HandPacket(ArrayList<Monster> hand)
    {
        this.hand = hand;
    }

    @Override
    public ArrayList<Monster> get(Channel ch) {
            return hand;
    }

    @Override
    public void setPacketClass() {
        type = 2;
    }
}
