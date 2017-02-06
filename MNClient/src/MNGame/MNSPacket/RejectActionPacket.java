package MNGame.MNSPacket;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class RejectActionPacket extends MNSPacket implements Serializable {
    String reason;
    public RejectActionPacket(String reason)
    {
        this.reason = "Action rejected:" + reason;
    }

    @Override
    public String get() {
        return reason;
    }

    @Override
    public void setPacketClass() {
        type = 4;
    }
}
