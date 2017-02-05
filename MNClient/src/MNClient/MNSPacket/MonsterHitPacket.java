package MNClient.MNSPacket;

import MNClient.GameCards.Monster;
import io.netty.channel.Channel;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class MonsterHitPacket extends MNSPacket implements Serializable {
    Monster monster;
    int index;
    boolean isMine;

    public MonsterHitPacket(Monster monster, int index, boolean isMine)
    {
        this.monster = monster;
        this.index = index;
        this.isMine = isMine;
    }

    @Override
    public Monster get() {
        return monster;
    }

    public int getIndex() {
        return index;
    }

    public boolean isMine() {
        return isMine;
    }

    @Override
    public void setPacketClass() {
        type = 5;
    }
}
