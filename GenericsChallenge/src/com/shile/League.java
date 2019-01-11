package com.shile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 10:04 2018/12/19
 */
public class League<T extends Team> {
    public String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean add(T team) {
        if (league.contains(team)) {
            return false;
        }
        league.add(team);
        return true;
    }
    public void showLeagueTable() {
        Collections.sort(league);
        for (T t : league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }

}
