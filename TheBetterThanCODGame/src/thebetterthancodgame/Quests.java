/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebetterthancodgame;

/**
 *
 * @author ethachu19
 */
public class Quests {
    int quest1 = 1;
    int quest2 = 2;
    int quest3 = 3;
    
    int numbertoKill1 = 1;
    int numbertoKill2 = 1;
    int numbertoKill3 = 1;
    
    boolean firstTime1 = true;
    boolean firstTime2 = true;
    boolean firstTime3 = true;
    
    String name1;
    String name2;
    String name3;
    
    public String getQuests()
    {
        String msg = "";
        switch (((quest1+5) % 6))
        {
            case 0:
                if(numbertoKill1 % 5 == 0 && !firstTime1)
                {
                    numbertoKill1 += 5;
                }else{
                    numbertoKill1 = 5;
                }
                name1 = "Beaver";
                break;
            case 1:
                name1 = "Sneaky Beaver";
                firstTime1 = false;
                break;
            case 2:
                name1 = "Justin Beaver";
                break;
            case 3:
                name1 = "Sneaky Beaky CT";
                break;
            case 4:
                name1 = "Stalin";
                break;
            case 5:
                name1 = "Trump";
                break;
        }
        
        msg+= "Quest 1: Kill " + numbertoKill1 + " " + name1 + "s \n";
        
        switch (((quest2+5) % 6))
        {
            case 0:
                name2 = "Beaver";
                break;
            case 1:
                if(numbertoKill2 % 5 == 0 && !firstTime2)
                {
                    numbertoKill2 += 5;
                }else{
                    numbertoKill2 = 5;
                }
                name2 = "Sneaky Beaver";
                break;
            case 2:
                name2 = "Justin Beaver";
                firstTime2 = false;
                break;
            case 3:
                name2 = "Sneaky Beaky CT";
                break;
            case 4:
                name2 = "Stalin";
                break;
            case 5:
                name2 = "Trump";
                break;
        }
        
        msg+= "Quest 2: Kill " + numbertoKill2 + " " + name2 + "s \n";
        
        switch (((quest3+5) % 6))
        {
            case 0:
                name3 = "Beaver";
                break;
            case 1:
                name3 = "Sneaky Beaver";
                break;
            case 2:
                if(numbertoKill3 % 5 == 0 && !firstTime3)
                {
                    numbertoKill3 += 5;
                }else{
                    numbertoKill3 = 5;
                }
                name3 = "Justin Beaver";
                break;
            case 3:
                name3 = "Sneaky Beaky CT";
                firstTime3 = false;
                break;
            case 4:
                name3 = "Stalin";
                break;
            case 5:
                name3 = "Trump";
                break;
        }
        
        msg+= "Quest 3: Kill " + numbertoKill3 + " " + name3 + "s \n";
        return msg;
    }
}
