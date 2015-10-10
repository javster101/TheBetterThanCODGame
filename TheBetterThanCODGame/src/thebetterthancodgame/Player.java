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
    public double health = 15;
    public double maxHealth = 15;
    public int level = 1;
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
        if(health > maxHealth)
            health = maxHealth;
    }
    public boolean use(String item)
    {
        Item lastItem = inv.currentItem;
        if(!inv.use(item))
            return false;
        if(inv.currentItem.damage == 0 && inv.currentItem.healthRegen > 0)
        {
            heal((int) inv.currentItem.healthRegen);
            inv.remove(item);
            inv.use(lastItem.name);
        }
        return true;
    }
    public void levelUp(){
        level++;
        maxHealth += 5;
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
                inv.currentItem.xp += this.level*5;
                if(inv.currentItem.xp >= 100 + (30*(inv.currentItem.level-1)))
                    inv.currentItem.levelUp();
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
                msg += "Enemy " + e.name + " hit you! \n";
                if(health < 0)
                    msg += "You have died! \n";
            }
        }
        return msg;
    }
}
