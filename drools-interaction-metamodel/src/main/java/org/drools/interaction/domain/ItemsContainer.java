/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.interaction.domain;

import java.util.List;

/**
 *
 * @author salaboy
 */
public interface ItemsContainer {
    public List<String> getItems();
   
    public void addItem(String itemId);
    
}
