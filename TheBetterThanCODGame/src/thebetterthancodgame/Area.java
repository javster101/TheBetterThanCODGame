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
public class Area {
    Enemy e;
    Vector2f pos;
    int level;
    public Area(Vector2f p, int l, Enemy e){
        this.pos = p;
        level = l;
        this.e = e;
    }
}
