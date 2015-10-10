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
public class Item {
    double damage;
    double healthRegen;
    int accuracy;
    int wear;
    int level = 1;
    int xp = 0;
    ItemList names;
    String name;
    boolean defined = false;
    
    public Item(ItemList names)
    {
        this.names = names;
        set(names);
        defined = true;
    }
    
    public final void set(ItemList names)
    {
        switch (names)
        {
            case Airhorn:
                damage = 1000;
                level = 12;
                wear = -1;
                accuracy = 95;
                name = "Airhorn";
                break;
            case Negev:
                damage = 50;
                level = 8;
                wear = 55;
                accuracy = 75;
                name = "Negev";
                break;
            case Glock18:
                damage = 20;
                level = 6;
                wear = 20;
                accuracy = 85;
                name = "Glock";
                break;
            case Mace:
                damage = 10;
                level = 4;
                wear = 15;
                accuracy = 90;
                name = "Mace";
                break;
            case BowandArrow:
                damage = 9;
                level = 3;
                wear = 15;
                accuracy = 85;
                name = "BowandArrow";
                break;
            case Sword:
                damage = 8;
                level = 2;
                wear = 15;
                accuracy = 100;
                name = "Sword";
                break;
            case Dagger:
                damage = 3;
                level = 1;
                wear = 20;
                accuracy = 90;
                name = "Dagger";
                break;
            default:
                level = 1;
                wear = 1;
                accuracy = 100;
                damage = 0;
                break;
        }
        
        switch (names)
        {
            case Airhorn:
                healthRegen = 50;
                name = "Airhorn";
                break;
            case Doritos:
                healthRegen = 35;
                name = "Doritos";
                break;
            case MountainDew:
                healthRegen = 15;
                name = "MountainDew";
                break;
            case Negev:
                healthRegen = 10;
                name = "Negev";
                break;
            case Medkit:
                healthRegen = 5;
                name = "Medkit";
                break;
            default:
                healthRegen = 0;
                break;
        }
    }
    
    public boolean enchant(int playerLevel)
    {
        if(this.level <= playerLevel)
        {
            name = "Enchanted " + name;
            damage = damage * 1.5;
            healthRegen = healthRegen * 1.25;
            this.level++;
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public void levelUp()
    {
        level++;
        damage = (int)(damage*Math.sqrt(level));
        healthRegen = (int)(healthRegen*Math.sqrt(level));
        xp = 0;
    }

}