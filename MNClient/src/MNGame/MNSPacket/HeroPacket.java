package MNGame.MNSPacket;

import MNGame.GameCards.Hero;

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
    public Hero get() {
        return h;
    }

    @Override
    public void setPacketClass() {
        type = 1;
    }

}
