import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public abstract class Monster extends GameCard implements Serializable {
    int maxhp,hp,attack,level,chargeTime,chargeLeft;
    Hero master,enemy;
    String penaltyDescription,deathDescription;
    boolean isAlive = false;

    Monster(String name, int hp, int attack, int level, int chargeTime)
    {
        setT();
        this.name = name;
        this.maxhp = this.hp = hp;
        this.attack = attack;
        this.level = level;
        this.chargeTime = chargeTime;
        this.chargeLeft = chargeTime;
        this.isAlive = true;
    }

    @Override
    public void setT() {
        type = "MNServer.GameCards.Hero.Monsters.Monster";
    }

    public void setMaster(Hero master) {
        this.master = master;
    }

    public void setEnemy(Hero enemy) {
        this.enemy = enemy;
    }

    public void chargeUp()
    {
        chargeLeft--;
    }

    public void getHit(int attackValue)
    {
        hp -= attackValue;
        if(hp<=0) death();
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getLevel() {
        return level;
    }

    public int getChargeTime() {
        return chargeTime;
    }

    public int getChargeLeft() {
        return chargeLeft;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public String getPenaltyDescription() {
        return penaltyDescription;
    }

    public String getDeathDescription() {
        return deathDescription;
    }

    public abstract void  death();
    public abstract void penalty();
    public abstract void setDeathDescription();
    public abstract void setPenaltyDescription();
}