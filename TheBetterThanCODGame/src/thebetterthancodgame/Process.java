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
         m = m.toLowerCase();
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
         if("get".equals(words[0])){
             if(world.getItem(world.p.inv,world.p.getPos())){
                return "Picked up item!";
             }else{
                return "There's nothing to get!"; 
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
             }catch(ArrayIndexOutOfBoundsException e){
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
                 if(world.p.pos.y < 1){
                     world.p.pos.y = 1;
                 }
             }
             return toReturn;
                     
         }
         if("remove".equals(words[0])|| "drop".equals(words[0])){
             if(world.p.inv.remove(words[1])/* | world.p.inv.use(words[2])*/){
                return "You have removed " + words[1];
             }else{
                return "You don't have this anyway"; 
             }
         }
         if("enchant".equals(words[0]))
         {
             int ret = world.p.enchant(words[1]);
             if(ret == -2){
                 return "You do not have a high enough level";
             }else if(ret == -1){
                 return "You do not have this item";
             }else{
                 return words[1] + " enchanted";
             }
         }
         return "Command not found";
     }
}
