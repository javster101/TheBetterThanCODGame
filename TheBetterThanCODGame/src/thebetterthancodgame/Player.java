/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thebetterthancodgame;

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
    public Player(int level){
        this.level = level;
        inv = new Inventory(20);
        this.i = i;
    }
    public void setPos(Vector2f f){
        pos = f;
    }
    public void damage(int i){
        health -= i;
    }
    public void attack(){
        
    }
}
