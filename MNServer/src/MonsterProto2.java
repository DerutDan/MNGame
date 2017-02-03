import MNServer.GameCards.Hero.Monsters.Monster;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class MonsterProto2 extends Monster implements Serializable{
    MonsterProto2() {
        super("MonsterProto2", 30, 8, 4, 3);
    }

    @Override
    public void death() {
        master.getHit(15);
    }

    @Override
    public void penalty() {
        enemy.getHit(5);
    }

    @Override
    public void setDeathDescription() {
        deathDescription = "Master takes 15 damage";
    }

    @Override
    public void setPenaltyDescription() {
        penaltyDescription = "Enemy takes 5 damage";
    }
}
