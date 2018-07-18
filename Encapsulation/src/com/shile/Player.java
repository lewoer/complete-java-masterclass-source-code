package com.shile;

public class Player {
    public String name;
    public int health;
    public String weapon;

    public void loseHeath(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            System.out.println("players knocked out");
            // reduce number of lives remaining for the player
        }

    }

    public int healthRemaining() {
        return this.health;
    }
}
