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
    }
    
    public final void set(ItemList names)
    {
        switch (names)
        {
            case Airhorn:
                damage = 1000;
                name = "Airhorn";
                break;
            case Negev:
                damage = 500;
                name = "Negev";
                break;
            case Glock18:
                damage = 200;
                name = "Glock 18";
                break;
            case Mace:
                damage = 100;
                name = "Mace";
                break;
            case Sword:
                damage = 50;
                name = "Sword";
                break;
            case Dagger:
                damage = 10;
                name = "Dagger";
                break;
            default:
                damage = 0;
                break;
        }
        
        switch (names)
        {
            case Airhorn:
                healthRegen = 100;
                name = "Airhorn";
                break;
            case Doritos:
                healthRegen = 35;
                name = "Doritos";
                break;
            case MountainDew:
                healthRegen = 15;
                name = "Mountain Dew";
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
    
    public void enchant()
    {
        name = "Enchanted " + name;
        damage = damage * 1.5;
        healthRegen = healthRegen * 1.25;
    }
    
    public void use()
    {
        
}

}
