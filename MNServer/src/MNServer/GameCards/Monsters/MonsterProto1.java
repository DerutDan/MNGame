package MNServer.GameCards.Monsters;
import MNServer.GameCards.Monster;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class MonsterProto1 extends Monster implements Serializable {


    public MonsterProto1() {
        super("MonsterProto1", 10, 2, 2, 2);
    }

    @Override
    public void death() {
        enemy.healUp(20);
        isAlive = false;
    }

    @Override
    public void penalty() {
        maxhp+=2;
        hp+=2;
        attack+=1;
        if(attack>=10)
            enemy.attackMonster(this);
    }

    @Override
    public void setDeathDescription() {
        penaltyDescription = "+2/+1. If it has 10 or more attack, attacks enemy\n";
    }

    @Override
    public void setPenaltyDescription() {
        deathDescription = "Heals enemy for 20 points\n";
    }
}
