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
public class Minimap {
    Enemy[][] map = new Enemy[3][3];
    Vector2f ppos;
    World w;
    public Minimap(Vector2f p, World w){
        ppos = p;
        this.w = w;
    }
    public Enemy[][] update(Vector2f p){
        map[1][1] = w.worldmap[(int)p.x-1][(int)p.y+1].e;
        map[1][1] = w.worldmap[(int)p.x][(int)p.y+1].e;
        map[1][1] = w.worldmap[(int)p.x+1][(int)p.y+1].e;
        map[1][1] = w.worldmap[(int)p.x-1][(int)p.y].e;
        map[1][1] = w.worldmap[(int)p.x][(int)p.y].e;
        map[1][1] = w.worldmap[(int)p.x+1][(int)p.y].e;
        map[1][1] = w.worldmap[(int)p.x-1][(int)p.y-1].e;
        map[1][1] = w.worldmap[(int)p.x][(int)p.y-1].e;
        map[1][1] = w.worldmap[(int)p.x+1][(int)p.y-1].e;
        return map;
    }
}
