/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.interaction.domain;

import java.util.UUID;

/**
 *
 * @author salaboy
 */
public abstract class Item implements ContextualItem{
    private String id;
    private String context;

    public Item() {
        this.id = UUID.randomUUID().toString();
    }
    
    
    
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    
    
}
