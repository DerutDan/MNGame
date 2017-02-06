package MNGame.MNSPacket;

import MNGame.GameCards.Monster;

import java.io.Serializable;
import java.util.ArrayList;


public class HandPacket extends MNSPacket implements Serializable {
    ArrayList<Monster> hand;
    public HandPacket(ArrayList<Monster> hand)
    {
        this.hand = hand;
    }

    @Override
    public ArrayList<Monster> get() {
            return hand;
    }

    @Override
    public void setPacketClass() {
        type = 2;
    }
}
