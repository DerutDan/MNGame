import MNServer.GameCards.Hero.Monsters.Monster;
import io.netty.channel.Channel;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class TakeCardPacket extends MNSPacket implements Serializable {
    Monster monster;
    TakeCardPacket(Monster monster)
    {
        this.monster = monster;
    }
    @Override
    public void send(Channel ch) {
        ch.write(monster);
        ch.flush();
    }

    @Override
    public int getPacketClass() {
        return 3;
    }
}
