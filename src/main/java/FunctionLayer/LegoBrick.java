/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Stephan
 */
public class LegoBrick {
    private int size;
    private int amount;

    public LegoBrick(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        if (size == 4) return ":::: x" + amount;
        if (size == 2) return "::: x" + amount;
        if (size == 1) return ":: x" + amount;
        return null;
    }   
}