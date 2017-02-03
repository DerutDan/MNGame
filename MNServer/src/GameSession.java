
import io.netty.channel.Channel;

import java.util.ArrayList;

/**
 * Created by Danila on 02.02.17.
 */
public class GameSession {
    private Channel ch1,ch2;
    private Hero h1,h2;
    private boolean aquired1 = false,aquired2 = false,gameIsOn = false,p1exausted,p2exausted;
    private ArrayList<Monster> handp1,handp2,deckp1,deckp2,monstersp1,monstersp2;
    int phase; //whos turn? 1 - p1, 2 - p2;

    public int aquire(Channel ch)
    {
        if(!aquired1)
        {
            aquired1 = true;
            ch1 = ch;
            if(aquired1&&aquired2)
            {
                gameIsOn = true;
            }
            return 1;
        }
        else if(!aquired2)
        {
            aquired2 = true;
            ch2 = ch;
            if(aquired1&&aquired2) gameIsOn = true;
            return 2;
        }
        else return 0;
    }

    void disconnected(int player)
    {
        if(player == 1) aquired1 = false;
        else aquired2 = false;
        gameIsOn = false;
    }

    public boolean isGameIsOn() {
        return gameIsOn;
    }
    public void init()
    {
        deckp1 = StatVar.getRandomDefaultDeck();
        deckp2 = StatVar.getRandomDefaultDeck();
        h1 = new Hero();
        h2 = new Hero();
        takeCard(deckp1, handp1, ch1, StatVar.initialHandSize);
        takeCard(deckp2, handp2, ch2, StatVar.initialHandSize);

        //new HandPacket(handp1).write(ch1);
        new HeroPacket(h1,true).write(ch1);
        new HeroPacket(h2,false).write(ch1);

        //new HandPacket(handp2).write(ch2);
        new HeroPacket(h1,false).write(ch2);
        new HeroPacket(h2,true).write(ch2);
        p1exausted = false;
        p2exausted = true;
        phase = 1;
    }

    public void takeCard(ArrayList<Monster> deck,ArrayList<Monster> hand,Channel ch)
    {
        if(!deck.isEmpty() && hand.size() < StatVar.maxHandSize)
        {
            Monster m = deck.get(deck.size()-1);
            hand.add(m);
            new TakeCardPacket(m).write(ch);
        }
    }
    public void takeCard(ArrayList<Monster> deck,ArrayList<Monster> hand, Channel ch, int count)
    {
        for(int i = 0; i < count;++i)
            takeCard(deck,hand,ch);
    }
    public void playerAttack(Channel player,int monsterIndex)
    {
        if(player == ch1)
        {
            if(phase == 1)
            {
                if(h1.isExausted()) new RejectActionPacket("You are exausted!").write(ch1);
                else
                {
                    if(monsterIndex < 0 || monsterIndex >= monstersp2.size())
                        new RejectActionPacket("No such a monster!").write(ch1);
                    else
                    {
                        Monster m = monstersp2.get(monsterIndex);
                        h1.attackMonster(m);
                        new MonsterHitPacket(m,monsterIndex,false).write(ch1);
                        new MonsterHitPacket(m,monsterIndex,true).write(ch2);
                        new HeroPacket(h1,true).write(ch1);
                        new HeroPacket(h1,false).write(ch2);
                        new HeroPacket(h2,true).write(ch2);
                        new HeroPacket(h2,false).write(ch1);
                    }
                }
            }
            else
            {
                new RejectActionPacket("Not your turn").write(ch1);
            }
        }
        else
        {
            if(phase == 2)
            {
                if(h2.isExausted()) new RejectActionPacket("You are exausted!").write(ch2);
                else
                {
                    if(monsterIndex < 0 || monsterIndex >= monstersp1.size())
                        new RejectActionPacket("No such a monster!").write(ch2);
                    else
                    {
                        Monster m = monstersp2.get(monsterIndex);
                        h2.attackMonster(m);
                        new MonsterHitPacket(m,monsterIndex,false).write(ch2);
                        new MonsterHitPacket(m,monsterIndex,true).write(ch1);
                        new HeroPacket(h2,true).write(ch2);
                        new HeroPacket(h2,false).write(ch1);
                        new HeroPacket(h1,true).write(ch1);
                        new HeroPacket(h1,false).write(ch2);

                    }
                }
            }
            else
            {
                new RejectActionPacket("Not your turn").write(ch2);
            }
        }
    }
    public void playMonster(Channel player,int cardIndex)
    {
        if(player == ch1)
        {
            if(phase == 1)
            {
                if(cardIndex < 0 || cardIndex >= handp1.size()) new RejectActionPacket("No such a card!").write(ch1);
                else
                {
                    Monster m = handp1.get(cardIndex);
                    if(h1.playCard(m))
                    {
                        monstersp1.add(m);
                        handp1.remove(cardIndex);
                        new MonsterAddedPacket(m,cardIndex,true).write(ch1);
                        new MonsterAddedPacket(m,cardIndex,false).write(ch2);
                    }
                    else new RejectActionPacket("Not enough mana").write(ch1);
                }
            }
            else new RejectActionPacket("Not your turn").write(ch1);
        }
        else if(player == ch2)
        {
            if(phase == 2)
            {
                if(cardIndex < 0 || cardIndex >= handp2.size()) new RejectActionPacket("No such a card!").write(ch2);
                else
                {
                    Monster m = handp2.get(cardIndex);
                    if(h2.playCard(m))
                    {
                        monstersp2.add(m);
                        handp2.remove(cardIndex);
                        new MonsterAddedPacket(m,cardIndex,true).write(ch2);
                        new MonsterAddedPacket(m,cardIndex,false).write(ch1);
                    }
                    else new RejectActionPacket("Not enough mana").write(ch2);
                }
            }
            else new RejectActionPacket("Not your turn").write(ch2);
        }
    }
    public void endTurn(Channel player)
    {
        if(ch1 == player)
        {
            if(phase == 1)
            {
                phase = 2;
                h2.turnStart();
                new HeroPacket(h2,true).write(ch2);
                new HeroPacket(h2,false).write(ch1);
                takeCard(deckp2,handp2,ch2);
            }
            else new RejectActionPacket("Not yout turn").write(ch1);
        }
        else if(ch2 == player)
        {
            if(phase == 2)
            {
                phase = 1;
                h1.turnStart();
                new HeroPacket(h1,true).write(ch1);
                new HeroPacket(h1,false).write(ch2);
                takeCard(deckp1,handp1,ch1);
            }
            else new RejectActionPacket("Not yout turn").write(ch2);
        }
    }

}
