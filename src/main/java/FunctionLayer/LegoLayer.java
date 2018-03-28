/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Stephan
 */
public class LegoLayer {
    private int level;
    private Map<Integer, LegoBrick> northside;
    private Map<Integer, LegoBrick> southside;
    private Map<Integer, LegoBrick> eastside;
    private Map<Integer, LegoBrick> westside;

    LegoLayer() {
        this.level = 0; // Default
        this.northside = new HashMap();
        this.southside = new HashMap();
        this.eastside = new HashMap();
        this.westside = new HashMap();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    
    public int getBrickAmount( int brickType ) {
        int amount = 0;
        amount += northside.get( brickType ).getAmount();
        amount += southside.get( brickType ).getAmount();
        amount += eastside.get( brickType ).getAmount();
        amount += westside.get( brickType ).getAmount();
        return amount;
    }

    public Map<Integer, LegoBrick> getNorthside() {
        return northside;
    }

    public Map<Integer, LegoBrick> getSouthside() {
        return southside;
    }

    public Map<Integer, LegoBrick> getEastside() {
        return eastside;
    }

    public Map<Integer, LegoBrick> getWestside() {
        return westside;
    }

    public Map<Integer, LegoBrick> getSide(String side) {
        switch (side) {
            case "N" : return northside;
            case "S" : return southside;
            case "E" : return eastside;
            case "W" : return westside;
        }
        return null;
    }

    @Override
    public String toString() {
        String result  = "";
        for (Map.Entry me : northside.entrySet()) {
          result += me.getValue() + " ";
        } result += "\n";
        
        for (Map.Entry me : southside.entrySet()) {
          result += me.getValue() + " ";
        } result += "\n";
        
        for (Map.Entry me : eastside.entrySet()) {
          result += me.getValue() + " ";
        } result += "\n";
        
        for (Map.Entry me : westside.entrySet()) {
          result += me.getValue() + " ";
        } result += "\n";
        
        return result;
    }
}
