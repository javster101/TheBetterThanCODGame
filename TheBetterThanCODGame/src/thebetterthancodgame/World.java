/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thebetterthancodgame;

import java.util.Random;

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
        int xb = r.nextInt()%9;
        int yb = r.nextInt()%9;
        for(int j = 0; j < 100; j++){
            for(int k = 0; k < 100; k++){
                int levelDev = (r.nextInt() % 3)-1;
                int chanceofblank = r.nextInt()%6;
                int level = Math.max(Math.abs(j-50), Math.abs(k-50));
                int enTypeGen = r.nextInt()%12;
                Enemy e = new Enemy(0,0,EnemyType.BLANK,"",0,0);
                worldmap[j][k] = new Area(new Vector2f(j,k), level + levelDev,e);
                worldmap[j][k].i = new Item(ItemList.Blank); 
                if(level > 3 && enTypeGen < 6){
                    worldmap[j][k].i = new Item(ItemList.Medkit);                    
                }
                if(level > 2 && enTypeGen < 3){
                    worldmap[j][k].i = new Item(ItemList.Dagger);                  
                }
                if(level > 4 && enTypeGen > 9){
                    worldmap[j][k].i = new Item(ItemList.BowandArrow);                  
                }
                if(level > 4 && enTypeGen < 3){
                    worldmap[j][k].i = new Item(ItemList.Sword);                  
                }
                if(level > 6 && enTypeGen < 2){
                    worldmap[j][k].i = new Item(ItemList.Mace);                  
                }
                if(level > 15 && enTypeGen > 10){
                    worldmap[j][k].i = new Item(ItemList.Glock18);                  
                }
                if(level > 30 && enTypeGen > 11){
                    worldmap[j][k].i = new Item(ItemList.MountainDew);                  
                }
                if(level > 30 && enTypeGen < 1){
                    worldmap[j][k].i = new Item(ItemList.Negev);                  
                }                              
                if(chanceofblank == 2){
                    worldmap[j][k].e = new Enemy(0,0,EnemyType.BLANK,"",0,0);
                    continue;
                }
                  
                switch(enTypeGen){
                    case 0:
                    case 1:
                    case 2:
                    case 8:
                    case 11:
                        e = new Enemy(level+levelDev, level, EnemyType.BEAVER,"Beaver",10*(level / 2),1);
                        break;
                    case 3:
                    case 7:
                        e = new Enemy(level+levelDev, level, EnemyType.SNEAKYBEAVER,"Sneaky Beaver",10*(level / 2),1);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                        e = new Enemy(level+levelDev, level, EnemyType.JUSTINBEAVER,"Justin Beaver",10*(level / 2),1);
                        break;
                    case 10:
                        e = new Enemy(level+levelDev, level, EnemyType.SNEAKYBEAKYCT,"Sneaky Beaky CT",10 * (level / 2),3);
                        break;
                }
                if(level > 30 && (enTypeGen  < 3)){
                     e = new Enemy(level+levelDev, level, EnemyType.STALIN,"Stalin",10 * (level / 2),5);
                }
                if((xb + 40) == j && (yb + 40) == k){
                    worldmap[j][k].e = new Enemy(50,50,EnemyType.BOSS,"BOSS",100,80);
                } 
               
                worldmap[j][k] = new Area(new Vector2f(j,k), level + levelDev,e);
                
            }
        }
    }
    public Area getArea(Vector2f p) throws ArrayIndexOutOfBoundsException{
        return worldmap[(int)p.x][(int)p.y];
    }
    public String printInfo(Vector2f s){
        String msg = "";
        if(worldmap[(int)s.x][(int)s.y].e.e == EnemyType.BLANK){
            msg += "There are no enemies\n";
            try{
                if(worldmap[(int)s.x][(int)s.y].i.name.trim() != ""){
                    msg += "There is a " + worldmap[(int)s.x][(int)s.y].i.name + " on the floor.\n";
                }
            }catch(NullPointerException e){
            
            }
        }else{
            msg += "There is a level " +  worldmap[(int)s.x][(int)s.y].e.level + " " + worldmap[(int)s.x][(int)s.y].e.name + " here!";
        }
        return msg;
    }
    public boolean getItem(Inventory i, Vector2f s){
        if(!(worldmap[(int)s.x][(int)s.y].i.names == ItemList.Blank)){
            i.add(worldmap[(int)s.x][(int)s.y].i);
            System.out.println(worldmap[(int)s.x][(int)s.y].i.name);
            worldmap[(int)s.x][(int)s.y].i = new Item(ItemList.Blank);
            return true;
        }
        return false;
    }
}
