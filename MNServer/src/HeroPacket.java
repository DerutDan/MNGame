import io.netty.channel.Channel;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class HeroPacket extends MNSPacket implements Serializable {
    boolean isMine;
    Hero h;

    HeroPacket(Hero h, boolean isMine)
    {
        this.h = h;
        this.isMine = isMine;
    }

    @Override
    public void send(Channel ch) {
        ch.write(isMine);
        ch.write(h);
        ch.flush();
    }

    @Override
    public int getPacketClass() {
        return 1;
    }
}
