package MNGame.MNSPacket;


public class DisconnectPacket extends MNSPacket {
    String reason;
    public DisconnectPacket(String reason)
    {
        this.reason = reason;
    }
    @Override
    public  String get() {
        return reason;
    }

    @Override
    public void setPacketClass() {
        type = 10;
    }
}
