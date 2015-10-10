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
    public String texNameType;
    
    public Enemy(double health, int level, EnemyType e, String name, int xpGain, int accuracy){
        this.health = health;
        this.level = level;
        this.e = e; 
        this.xpGain = xpGain;
        this.accuracy = accuracy;
        this.name = name;
        
        if(e == EnemyType.BOSS)
            level = 50;
        switch(e)
        {
            case JUSTINBEAVER:
                texNameType = "justinbeaver.png";
                break;
            case BEAVER:
                texNameType = "beaver.png";
                break;
            case SNEAKYBEAVER:
                texNameType = "sneakybeaver.png";
                break;
            case SNEAKYBEAKYCT:
                texNameType = "sneaky beaky ct.png";
                break;
            case BLANK:
                texNameType = null;
                break;
            case BOSS:
                texNameType = "boss.png";
                break;
            case STALIN:
                texNameType = "stalin.png";
                break;
            case TRUMP:
                texNameType = "trump.png";
                break;
        }
    }
    public String attack(Player p){
        String message = "";
        int damage = 0;
        Random r = new Random();
        int headshotPercent = r.nextInt()%(10-accuracy);
        
        switch(e)
        {
            case JUSTINBEAVER:
                damage = 3 * level;
                message = "The Justin Beaver has hit you for ";
                break;
            case BEAVER:
                damage = 2 * level;
                message = "The Beaver has hit you for ";
                break;
            case SNEAKYBEAVER:
                damage = 2 * level;
                message = "The Sneaky Beaver has hit you for ";
            case SNEAKYBEAKYCT:
                damage = 4 * level;
                message = "The Sneaky Beaky Counter Terrorist has hit you for ";
                break;
            case STALIN:
                damage = 5 * level;
                message = "Stalin has hit you for ";
                break;
            case BLANK:
                damage = 0;
                break;
            case BOSS:
                damage = 20;
                message = "The Boss has hit you for ";
                break;
            case TRUMP:
                damage = 4*level;
                message = "Donald Trump has hit you for ";
                break;
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
