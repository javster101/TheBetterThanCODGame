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
public class World {
    Area[][] worldmap = new Area[100][100];
    Player p;
    public World(){
        Random r = new Random();
        p = new Player(1, new Image("/simon.png"));
        p.setPos(new Vector2f(50,50));
        for(int j = 0; j < 100; j++){
            for(int k = 0; k < 100; k++){
                int levelDev = (r.nextInt() % 3)-1;
                int level = Math.max(Math.abs(j-50), Math.abs(k-50));
                System.out.println(level + levelDev);
                worldmap[j][k] = new Area(new Vector2f(j,k), level + levelDev);
            }
        }
    }
}
