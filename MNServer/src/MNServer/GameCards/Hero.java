package MNServer.GameCards;

import MNServer.GameCards.Hero.Monsters.Monster;
import MNServer.StatVar;

import java.io.Serializable;

/**
 * Created by Danila on 03.02.17.
 */
public class Hero extends GameCard implements Serializable {
    int maxhp,hp,attack,def,mana,currentMana;
    boolean exausted = true;
    public Hero()
    {
        maxhp = hp = StatVar.defaultHeroHp;
        attack = StatVar.defaultHeroAttack;
        def = StatVar.defaultHeroDef;
        mana = StatVar.defaultHeroMana;
    }
    @Override
    public void setT() {
        type = "Hero";
    }
    public void getHit(int attackValue)
    {
        int hit;
        if((hit = attackValue - def) > 0)
        hp -= hit;
        if(hp<=0) death();
    }



    public void death()
    {

    }
    public void healUp(int healValue)
    {
        hp+=healValue;
        if(hp > maxhp) hp = maxhp;
    }
    public boolean playCard(Monster m)
    {
        if(m.getLevel() > currentMana) return false;
        currentMana-=m.getLevel();
        return true;
    }
    public void exaust()
    {
        exausted = true;
    }
    public void attackMonster(Monster monster)
    {
        monster.getHit(attack);
        getHit(monster.getAttack());
        exaust();
    }
    public void turnStart()
    {
        mana++;
        currentMana = mana;
        exausted = false;
    }
    public int getAttack() {
        return attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public boolean isExausted() {
        return exausted;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getHp() {
        return hp;
    }

    public int getDef() {
        return def;
    }
}
