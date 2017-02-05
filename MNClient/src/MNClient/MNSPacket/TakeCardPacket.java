package MNClient.MNSPacket;

import MNClient.GameCards.Monster;
import io.netty.channel.Channel;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class TakeCardPacket extends MNSPacket implements Serializable {
    Monster monster;
    public TakeCardPacket(Monster monster)
    {
        this.monster = monster;
    }

    @Override
    public Monster get() {
        return monster;
    }

    @Override
    public void setPacketClass() {
        type = 3;
    }
}
