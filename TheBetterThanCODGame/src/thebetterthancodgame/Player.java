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
public class Player {
    public Inventory inv;
    public double health;
    public int level;
    public Image i;
    public Vector2f pos;
    public int xp;
    public Random accuracy = new Random();
    public Player(int level){
        this.level = level;
        inv = new Inventory(20);

    }
    public void setPos(Vector2f f){
        pos = f;
    }
    public Vector2f getPos(){
        return pos;
    }
    public void damage(int i){
        health -= i;
    }
    public void heal(int i){
        health += i;
    }
    public void levelUp(){
        level++;
        health += 5;
    }
    public String attack(World w){
        String msg = "";
        Area t = w.worldmap[(int)pos.x][(int)pos.y];
        if(t.e.e == EnemyType.BLANK){
            return "No enemy!";
        }else{
            Enemy e = t.e;
            if(accuracy.nextInt() % 100 <= inv.currentItem.accuracy)
            {
                e.health -= inv.currentItem.damage;
                msg += "Hit for " + inv.currentItem.damage + " damage! \n";
            }
            else
            {
                msg += "Missed! \n";
            }
            if(e.health < 0){
                msg += "Enemy " + e.name + "Killed!\n";
                xp += e.xpGain;
                if(xp > 10 * level){
                    levelUp();
                    msg += "LEVEL UP \n";
                }
            }else{
                e.attack(this);
                msg += "Enemy " + e.name + "hit you! \n";
            }
        }
        return msg;
    }
}
