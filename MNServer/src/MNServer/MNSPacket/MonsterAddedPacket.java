package MNServer.MNSPacket;

import MNServer.GameCards.Monster;
import io.netty.channel.Channel;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class MonsterAddedPacket extends MNSPacket implements Serializable {
    Monster monster;
    boolean isMine;
    public MonsterAddedPacket(Monster monster, boolean isMine)
    {
        this.monster = monster;
        this.isMine = isMine;
    }

    @Override
    public Monster get(Channel ch) {
        return monster;
    }

    public boolean isMine() {
        return isMine;
    }

    @Override
    public void setPacketClass() {
        type = 6;
    }
}
