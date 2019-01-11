package com.shile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer shile = new SoccerPlayer("Shile");

        Team<FootballPlayer> adelaiCrows = new Team<>("Adelai Crows");
        adelaiCrows.addPlayer(joe);
//        adelaiCrows.addPlayer(pat);
//        adelaiCrows.addPlayer(shile);

        System.out.println(adelaiCrows.numPlayer());

        Team<BaseballPlayer> baseballTeam  = new Team<>("chicago cubs");
        baseballTeam.addPlayer(pat);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");


        hawthorn.matchResult(fremantle,1,0);
        hawthorn.matchResult(adelaiCrows,3,8);

        adelaiCrows.matchResult(fremantle,2,1);
//        adelaiCrows.matchResult(baseballTeam,1,1);

        System.out.println("Ranking");
        System.out.println(adelaiCrows.getName() + ":" + adelaiCrows.ranking());
        System.out.println(melbourne.getName() + ":" + melbourne.ranking());
        System.out.println(adelaiCrows.compareTo(melbourne));
        System.out.println(adelaiCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaiCrows));



    }

}

