/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thebetterthancodgame;

import java.util.Random;
import javafx.scene.image.Image;

/**
 *
 * @author Javier
 */
public class Enemy {
    public double health;
    public int level;
    public Image i;
    public EnemyType e;
    public String name;
    public int xpGain;
    public int accuracy;
    public Enemy(double health, int level, EnemyType e, String name, int xpGain, int accuracy){
        this.health = health;
        this.level = level;
        this.e = e; 
        this.xpGain = xpGain;
        this.accuracy = accuracy;
    }
    public String attack(Player p){
        String message = "";
        int damage = 0;
        Random r = new Random();
        int headshotPercent = r.nextInt()%(10-accuracy);
        
        if(e == EnemyType.JUSTINBEAVER){
            damage = 3 * level;
            message = "The Justin Beaver has hit you for ";
        }
        if(e == EnemyType.BEAVER){
            damage = 2 * level;
            message = "The Beaver has hit you for ";
        }
        if(e == EnemyType.SNEAKYBEAVER){
            damage = 2 * level;
            message = "The Sneaky Beaver has hit you for ";
        }
        if(e == EnemyType.SNEAKYBEAKYCT){
            damage = 4 * level;
            message = "The Sneaky Beaky Counter Terrorist has hit you for ";
        }
        if(e == EnemyType.BLANK){
            damage = 0;
        }
        if(headshotPercent == 3 - accuracy){
            damage *= 2;
        }
        if(damage == 0){
            return message;
        }
        p.damage(damage);
        return message + damage;
    }
}
