package MNGame.MNSPacket;

/**
 * Created by Danila on 03.02.17.
 */
public class StartGamePacket extends MNSPacket {
    @Override
    public Object get() {
        return null;
    }

    @Override
    public void setPacketClass() {
        type = 9;
    }
}
