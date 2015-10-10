/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thebetterthancodgame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier
 */
public class Inventory {
    List<Item> items = new ArrayList<>();
    Item currentItem;
    int currentI = 0;
    int maxsize;
    public Inventory(int maxsize){
        this.maxsize = maxsize;
    }
    public boolean add(Item i){
        if(currentI > maxsize){
            return false;
        }
        items.add(i);
        currentI++;
        return true;
    }
    public boolean use(String s){
        for(Item item : items){
            if(item.name.toLowerCase().equals(s.toLowerCase())){
                currentItem = item;
                return true;
            }
        }
        return false;
    }
    public Item getUsedItem(){
        return currentItem;
    }
    public boolean remove(String s){
        boolean worked;
        for(Item item : items){
            if(item.name.toLowerCase().equals(s.toLowerCase())){
                
                items.remove(item);
                return true;
            }
            
        }
        return false;
    }
}
