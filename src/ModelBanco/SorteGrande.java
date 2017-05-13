/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBanco;

/**
 *
 * @author Emanuel Santana
 */
public class SorteGrande {
    private double total;
    
    public SorteGrande(){
    
    }

    /**
     * @return the total
     */
    public double verTotal() {
        return total;
    }

    /**
     * @param add the total to set
     */
    public void adicionarTotal(double add) {
        this.total = total + add;
    }
    
    public void retirarTotal(double add){
        this.total = total - add;
    }
    
    
}
