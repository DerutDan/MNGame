import io.netty.channel.Channel;

/**
 * Created by Danila on 03.02.17.
 */
public class StartTurnPacket extends MNSPacket {
    Channel ch;

    @Override
    public void send(Channel ch) {
        ch.writeAndFlush("Your turn");
    }

    @Override
    public void get(Channel ch) {

    }

    @Override
    public int getPacketClass() {
        return 7;
    }
}
