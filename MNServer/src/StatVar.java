import MNServer.GameCards.Hero.Monsters.Monster;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Danila on 03.02.17.
 */
public class StatVar {
    static int defaultHeroHp = 100, defaultHeroAttack = 5, defaultHeroDef = 0, defaultHeroMana = 1;
    static ArrayList<Monster> defaultMonsters = new ArrayList<>();
    static int defaultMonsterCount = 3;
    static int defaultDeckSize = 10;
    static int initialHandSize = 3;
    static int maxHandSize = 5;

    static boolean isDefaultDeckInited = false;
    static Random r = new Random();

    public static void initMonsterDeck() {
        defaultMonsters.add(new MonsterProto1());
        defaultMonsters.add(new MonsterProto2());
        defaultMonsters.add(new MonsterProto3());
    }

    public static ArrayList<Monster> getRandomDefaultDeck() {
        ArrayList<Monster> monsters = new ArrayList<>(defaultDeckSize);
        if (!isDefaultDeckInited) {
            for (int i = 0; i < defaultDeckSize; ++i) {
                int k = Math.abs(i + r.nextInt()) % defaultMonsterCount;
                switch (k) {
                    case 0: {
                        monsters.add(new MonsterProto1());
                        break;
                    }
                    case 1: {
                        monsters.add(new MonsterProto2());
                        break;
                    }
                    case 2: {
                        monsters.add(new MonsterProto3());
                        break;
                    }
                }
            }
        }
        return monsters;
    }
}
