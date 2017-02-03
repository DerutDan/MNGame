package MNClient.GameCards.Monsters;

import MNClient.GameCards.Monster;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class MonsterProto3 extends Monster implements Serializable {
    public MonsterProto3() {
        super("MonsterProto3", 100, 4, 6, 3);
    }

    @Override
    public void death() {
        master.getHit(enemy.getAttack());
        isAlive = false;
    }

    @Override
    public void penalty() {
        this.getHit(10);
        if(isAlive) {
            enemy.getHit(this.getAttack());
            this.getHit(enemy.getAttack());
        }
    }

    @Override
    public void setDeathDescription() {
        deathDescription = "Enemy hits master";
    }

    @Override
    public void setPenaltyDescription() {
        penaltyDescription = "MNServer.GameCards.Hero.Monsters.Monster takes 10 damage and attacks enemy";
    }
}
