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
    int quest1killed = 0;
    int quest2killed = 0;
    int quest3killed = 0;
    public Inventory inv;
    public double health = 15;
    public double maxHealth = 15;
    public int level = 1;
    public Image i;
    public Vector2f pos;
    public int xp;
    public Random accuracy = new Random();
    Quests quest = new Quests();
    public Player(int level){
        this.level = level;
        inv = new Inventory(20);
        pos = new Vector2f(50,50);
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
            inv.items.remove(inv.currentItem);
            inv.currentI--;
            inv.use(lastItem.name);
        }
        return true;
    }
    public void levelUp(){
        level++;
        maxHealth += 5;
        health = maxHealth;
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
                inv.currentItem.wear--;
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
            if(inv.currentItem.wear == 0)
            {
                msg += inv.currentItem.name + " was broken. \n";
                inv.remove(inv.currentItem.name);
                inv.currentItem = null;
            }
            if(e.health < 0){
                msg += "Enemy " + e.name + " Killed!\n";
                xp += e.xpGain;
                w.worldmap[(int)pos.x][(int)pos.y].e = new Enemy(0,0,EnemyType.BLANK,"",0,0);
                if(e.name.equals(quest.name1))
                {
                    quest1killed++;
                }
                if(e.name.equals(quest.name2))
                {
                    quest2killed++;
                }
                if(e.name.equals(quest.name3))
                {
                    quest3killed++;
                }
                if(quest1killed == quest.numbertoKill1)
                {
                    quest.quest1++;
                    msg += "Quest 1 completed. \n";
                }
                if(quest2killed == quest.numbertoKill2)
                {
                    quest.quest2++;
                    msg += "Quest 2 completed. \n";
                }
                if(quest3killed == quest.numbertoKill3)
                {
                    quest.quest3++;
                    msg += "Quest 3 completed. \n";
                }
                try{
                    msg += "There is a " + t.i.name + " on the floor.\n";
                }catch(Exception ex){
                    
                }
                if(xp > 10 * level){
                    levelUp();
                    msg += "LEVEL UP \n";
                }
            }else{
                e.attack(this);
                msg += "Enemy " + e.name + " hit you! \n";
                if(health < 0){
                    msg += "You have died! \n";
                    w.respawn(this);
                }
            }
        }
        return msg;
    } 
    
    public int enchant(String name)
    {
        String lastName = inv.currentItem.name;
        if(!this.use(name))
            return -1;
        if(!inv.currentItem.enchant(this.level))
            return -2;
        return 1;
    }
}
