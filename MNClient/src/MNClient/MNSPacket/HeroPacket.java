package MNClient.MNSPacket;

import MNClient.GameCards.Hero;
import io.netty.channel.Channel;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class HeroPacket extends MNSPacket implements Serializable {
    public boolean isMine() {
        return isMine;
    }

    boolean isMine;
    Hero h;

    public HeroPacket(Hero h, boolean isMine)
    {
        this.h = h;
        this.isMine = isMine;
    }


    @Override
    public Hero get(Channel ch) {
        return h;
    }

    @Override
    public void setPacketClass() {
        type = 1;
    }

}
