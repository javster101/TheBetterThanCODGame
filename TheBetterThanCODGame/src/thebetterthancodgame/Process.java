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
public class Process {
    public static String processEvent(String msg, World world){
         String m = msg.trim();
         String[] words = m.split(" ");
         int argAm = words.length;
         String finMsg;
         if("attack".equals(words[0]) || "fight".equals(words[0])){
             return world.p.attack(world);
         }
         if("use".equals(words[0]) /*|| ("take".equals(words[0]) && "out".equals(words[1]))*/){
             if(world.p.use(words[1])/* | world.p.inv.use(words[2])*/){
                return "Now using " + words[1];
             }else{
                return "You don't have this"; 
             }
         }
         if("go".equals(words[0]) || "move".equals(words[0]) || "head".equals(words[0]) || "walk".equals(words[0])){
             switch(words[1]){
                case "north":
                case "up":
                case "forward":
                    world.p.pos.y += 1;
                    break;
                case "left":
                case "west":
                    world.p.pos.x -= 1;
                    break;
                case "south":
                case "down":
                case "back":
                case "backwards":
                    world.p.pos.y -= 1;
                    break;
                case "right":
                case "east":
                    world.p.pos.x += 1;
                    
                    break;
             }
             String toReturn = "";
             try{
                toReturn = world.printInfo(world.p.pos);
             }catch(Exception e){
                 toReturn = "Too far from center!";
                 if(world.p.pos.x > 98){
                     world.p.pos.x =90;
                 }
                 if(world.p.pos.x < 1){
                     world.p.pos.x =1;
                 }
                 if(world.p.pos.y > 98){
                     world.p.pos.y =90;
                 }
                 if(world.p.pos.y > 1){
                     world.p.pos.y = 1;
                 }
             }
             return toReturn;
                     
         }
         
         return "Command not found";
     }
}
