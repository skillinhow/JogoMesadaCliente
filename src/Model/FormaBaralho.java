/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author emanuel
 */
public class FormaBaralho {
    
    private Stack<ComprasEnt> bEnt;
    private Stack<Correios> bCorreio;
    
    public FormaBaralho(){
    
        this.bEnt = new Stack();
        this.bCorreio = new Stack();   
    }
    
    public Stack<Correios> fazerBaralhoCorreio(){
    
    Collections.shuffle(bCorreio);
    return bCorreio;
    }
    
    public Stack<ComprasEnt> fazerBaralhobEnt(){
    
    Collections.shuffle(bEnt);
    return bEnt;
    }
    
    
    
    
}
