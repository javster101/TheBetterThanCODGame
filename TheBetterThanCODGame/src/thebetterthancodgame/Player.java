/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thebetterthancodgame;

/**
 *
 * @author Javier
 */
public class Player {
    public Inventory inv;
    public double health;
    public int level;
    public Player(int level){
        this.level = level;
        inv = new Inventory(20);
        
    }
    
}
