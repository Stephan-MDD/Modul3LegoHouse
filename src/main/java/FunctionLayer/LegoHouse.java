/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Stephan
 */
public class LegoHouse {
    private final int lenght;
    private final int width;
    private final int heigth;
    
    private int doorWidth;
    private int doorHeight;
    
    private int windowWidth;
    private int windowHeight;
    private int windowLevelOffset;
    
    private int brick1;
    private int brick2;
    private int brick4;
    
    private List<LegoLayer> layers;
    private Map<Integer, Integer> bricks;

    public LegoHouse(int lenght, int witdh, int heigth) {
        this.lenght = lenght;
        this.width = witdh - 4; // the thickness of a brick is 2
        this.heigth = heigth;
        this.layers = new ArrayList();
        this.bricks = new HashMap();
        
        doorConstruct();
        windowConstruct();
        brickConstruct();
        addLayers();
    }
    
    private void doorConstruct() {
        this.doorWidth = 4;
        this.doorHeight = 6;
    }
    
    private void windowConstruct() {
        this.windowWidth = 4;
        this.windowHeight = 4;
        this.windowLevelOffset = 1;
    }
    
    private void brickConstruct() {
        this.brick1 = 1;
        this.brick2 = 2;
        this.brick4 = 4;
    }
    
    public LegoLayer layerBuilder(int tmpLelev) {
        LegoLayer layer = new LegoLayer();
        sideBuilder(layer, lenght, tmpLelev, "N");
        sideBuilder(layer, lenght, tmpLelev, "S");
        sideBuilder(layer, width, tmpLelev, "E");
        sideBuilder(layer, width, tmpLelev, "W");
        
        return layer;
    }
    
    private void sideBuilder(LegoLayer layer, int sideSize, int tmpLelev, String sideName) {
        int size = sideSize;
        layer.getSide(sideName).put(brick4, new LegoBrick(brick4));
        layer.getSide(sideName).get(brick4).setAmount(size / brick4);
        size %= brick4;
            
        layer.getSide(sideName).put(brick2, new LegoBrick(brick2));
        layer.getSide(sideName).get(brick2).setAmount(size / brick2);
        size %= brick2;
            
        layer.getSide(sideName).put(brick1, new LegoBrick(brick1));
        layer.getSide(sideName).get(brick1).setAmount(size);
    }
    
    public LegoLayer modifiedLayerBuilder(int tmpLelev, int unitWidth) {
        LegoLayer layer = new LegoLayer();
        modifiedSideBuilder(layer, lenght, tmpLelev, "N", unitWidth);
        modifiedSideBuilder(layer, lenght, tmpLelev, "S", unitWidth);
        sideBuilder(layer, width, tmpLelev, "E");
        sideBuilder(layer, width, tmpLelev, "W");
        
        return layer;
    }
    
    private void modifiedSideBuilder(LegoLayer layer, int sideSize, int tmpLelev, String sideName, int unitWidth) {        
        int brickSum;
        int sizeRight = (sideSize / 2) - (unitWidth / 2);
        int sizeLeft = (sideSize - sizeRight) - (unitWidth / 2);
        
        layer.getSide(sideName).put(brick4, new LegoBrick(brick4));
        
        brickSum = sizeRight / brick4 + sizeLeft / brick4;
        
        layer.getSide(sideName).get(brick4).setAmount(brickSum);
        sizeRight %= brick4;
        sizeLeft %= brick4;
            
        brickSum = sizeRight / brick2 + sizeLeft / brick2;
            
        layer.getSide(sideName).put(brick2, new LegoBrick(brick2));
        layer.getSide(sideName).get(brick2).setAmount(brickSum);
        sizeRight %= brick2;
        sizeLeft %= brick2;
            
        brickSum = sizeRight / brick2 + sizeLeft / brick2;
            
        layer.getSide(sideName).put(brick1, new LegoBrick(brick1));
        layer.getSide(sideName).get(brick1).setAmount(brickSum);
    }

    private void addLayers() {
        for (int i = 0; i < heigth; i++) {
            if (i < doorHeight) {
                modifiedLayerBuilder(i, doorWidth);
            }
            
            if (i > windowLevelOffset && i < windowHeight + windowLevelOffset) {
                modifiedLayerBuilder(i, windowWidth);
            } else layers.add(layerBuilder(i));
        }
    }
    
    public List<LegoLayer> getLayers() {
        return layers;
    }
    
    private int setBrickAmount(int brickType) {
        int amount = 0;
        for (LegoLayer l : layers) {
            amount += l.getBrickAmount(brickType);
        }
        return amount;
    }
    
    private void asignBrickAmount() {
        bricks.put( 1, setBrickAmount(1) );
        bricks.put( 2, setBrickAmount(2) );
        bricks.put( 4, setBrickAmount(4) );
    }
    
    public int getBrickAmount( int brickType ) {
        asignBrickAmount();
        return bricks.get(brickType);
    }
}
