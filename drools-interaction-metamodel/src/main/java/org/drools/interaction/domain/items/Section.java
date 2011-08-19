/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.interaction.domain.items;

import java.util.ArrayList;
import java.util.List;
import org.drools.interaction.domain.Item;
import org.drools.interaction.domain.ItemsContainer;

/**
 *
 * @author salaboy
 */
public class Section extends Item implements ItemsContainer{

    private List<String> items;

    public List<String> getItems() {
        return items;
    }

    public void addItem(String itemId) {
        if(this.items == null){
            this.items = new ArrayList<String>();
        }
        this.items.add(itemId);
    }
 
}
