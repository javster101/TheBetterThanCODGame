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
        p = new Player(1);
        p.setPos(new Vector2f(50,50));
        for(int j = 0; j < 100; j++){
            for(int k = 0; k < 100; k++){
                int levelDev = (r.nextInt() % 3)-1;
                int chanceofblank = r.nextInt()%6;
                int level = Math.max(Math.abs(j-50), Math.abs(k-50));
                int enTypeGen = r.nextInt()%12;
                Enemy e = new Enemy(0,0,EnemyType.BLANK,0,0);
                worldmap[j][k] = new Area(new Vector2f(j,k), level + levelDev,e);

                if(chanceofblank == 2){
                    worldmap[j][k].e = new Enemy(0,0,EnemyType.BLANK,0,0);
                    continue;
                }
                switch(enTypeGen){
                    case 0:
                    case 1:
                    case 2:
                    case 8:
                    case 11:
                        e = new Enemy(level+levelDev, level, EnemyType.BEAVER,10,1);
                        break;
                    case 3:
                    case 7:
                        e = new Enemy(level+levelDev, level, EnemyType.SNEAKYBEAVER,10,1);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                        e = new Enemy(level+levelDev, level, EnemyType.JUSTINBEAVER,10,1);
                        break;
                    case 10:
                        e = new Enemy(level+levelDev, level, EnemyType.SNEAKYBEAKYCT,10,3);
                        break;
                }
                System.out.println(e.e);
                worldmap[j][k] = new Area(new Vector2f(j,k), level + levelDev,e);
                
            }
        }
    }
}
