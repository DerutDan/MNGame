package MNServer.MNPacket;

import MNServer.GameCards.Monster;
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
    public void send(Channel ch) {
        ch.write(index);
        ch.write(monster);
        ch.flush();
    }

    @Override
    public void get(Channel ch) {

    }

    @Override
    public int getPacketClass() {
        return 5;
    }
}
