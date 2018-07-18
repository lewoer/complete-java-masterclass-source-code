package com.shile;

public class Main {

    public static void main(String[] args) {
//        Player player = new Player();
//        // 因为PLayer的field设置为public，下面才能够直接访问。
//        player.name = "shile";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHeath(damage);
//        System.out.println("Remaining health = " + player.healthRemaining());
//        damage = 11;
//        player.loseHeath(damage);
//        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("shile", 50, "Sword");
        System.out.println("Initial health is " + player.getHealth());

    }
}
