package com.shile;

import java.util.ArrayList;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 21:59 2018/12/18
 */
public class Team<T extends Player> implements Comparable<Team<T>>{
    private ArrayList<T> members = new ArrayList<>();
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;  // 平手，并列
    String message = null;


    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            // 参数palyer需要cast
            System.out.println(player.getName() + " is always on this list");
            return false;
        } else {
            members.add(player);
            System.out.println( player.getName() + " picked for team " + this.name);
            return true;
        }

    }

    public int numPlayer() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
            message = "beat";
        } else if (ourScore == theirScore) {
            tied++;
            message = "drew with";
        } else {
            lost++;
            message = " lost to";
        }
        played++;
        if (opponent != null) {
            // 更新对手数据
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
