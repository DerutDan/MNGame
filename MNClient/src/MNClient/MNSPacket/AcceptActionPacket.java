package MNClient.MNSPacket;

/**
 * Created by Danila on 03.02.17.
 */
public class AcceptActionPacket extends MNSPacket {
    @Override
    public Object get() {
        return null;
    }

    @Override
    public void setPacketClass() {
        type = 8;
    }
}
