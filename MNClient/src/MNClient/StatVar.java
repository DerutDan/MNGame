package MNClient;

import MNClient.GameCards.Monster;
import MNClient.GameCards.Monsters.*;

import java.util.ArrayList;

/**
 * Created by Danila on 03.02.17.
 */
public class StatVar {
    public static int defaultHeroHp = 100, defaultHeroAttack = 5, defaultHeroDef = 0, defaultHeroMana = 1;
    public static ArrayList<Monster> defaultMonsters = new ArrayList<>();
    public static int defaultMonsterCount = 3;
    public static int defaultDeckSize = 10;
    public static int initialHandSize = 3;
    public static int maxHandSize = 5;
    public static int menuFrameWidth = 600,menuFrameHeight = 600,menuButtonWidth = 200,menuButtonHeight = 50, menuButtonGap = 50;
    public static int logLabelWidth = 200,logLabelHeight = 50;
    public static int gameFrameWidth = 1200,gameFrameHeight = 600;
    public static boolean isDefaultDeckInited = false;

    public static void initMonsterDeck() {
        defaultMonsters.add(new MonsterProto1());
        defaultMonsters.add(new MonsterProto2());
        defaultMonsters.add(new MonsterProto3());
    }

}
