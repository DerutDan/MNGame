package MNGame.MNSPacket;

import MNGame.ClientInterface.GameFrame.GameFrame;
import MNGame.MNClient;

import java.util.PriorityQueue;

public class PacketPicker implements Runnable {
    PriorityQueue<MNSPacket> queue;
    GameFrame gf;
    boolean delay;
    boolean gameOn = true;
    MNClient client;
    public PacketPicker(MNClient client,PriorityQueue<MNSPacket> queue,GameFrame gf)
    {
        this.queue = queue;
        this.gf = gf;
        this.client = client;
    }
    @Override
    public void run() {
        while(gameOn) {
            if (queue.size() != 0) {
                MNSPacket packet = queue.poll();
                int type = packet.getT();
                //Hero - 1; Hand - 2; TakeCard - 3; RejectAction - 4; MonsterHit - 5; MonsterAdded - 6;
                //7 - Start turn; 8 - AcceptAction; 9 - StartGamePacket; 10 - Disconnect;
                switch (type) {
                    case 1: {
                        gf.upDateHero(((HeroPacket) packet).get());
                        break;
                    }
                    case 2: {
                        System.out.println("redundant");
                        break;
                    }
                    case 3: {
                        //TakeCard
                        gf.takeCard(((TakeCardPacket) packet).get());
                        break;
                    }
                    case 4: {
                        //ActionRejected
                        String reason = ((RejectActionPacket) packet).get();
                        gf.upDateLog(reason, true);
                        break;
                    }
                    case 5: {
                        MonsterHitPacket mhp = (MonsterHitPacket) packet;
                        gf.monsterHit(mhp.get(), mhp.getIndex(), mhp.isMine());
                        break;
                    }
                    case 6: {
                        MonsterAddedPacket map = (MonsterAddedPacket) packet;
                        gf.monsterAdded(map.get(), map.isMine());
                        break;
                    }
                    case 7: {
                        gf.startTurn();
                        break;
                    }
                    case 8: {
                        gf.upDateLog("Accepted", false);
                        break;
                    }
                    case 9: {
                        client.shift();
                        gf.gameStarted();

                        break;
                    }
                    case 10: {
                        gf.upDateLog(((DisconnectPacket) packet).get(), true);
                        gameOn = false;
                        break;
                    }
                }
            }
        }
    }
}
