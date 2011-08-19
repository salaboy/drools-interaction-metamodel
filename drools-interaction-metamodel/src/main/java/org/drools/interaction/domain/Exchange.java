/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.interaction.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author salaboy
 */
public class Exchange implements ItemsContainer {
    private String id;
    private List<String> items;
    private Status status;
    
    public Exchange() {
        this.id = UUID.randomUUID().toString();
        this.status = new Status(this.getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public List<String> getItems() {
        return items;
    }
    
    public void addItem(String itemId) {
        if (this.items == null) {
            this.items = new ArrayList<String>();
        }
        this.items.add(itemId);
    }
    
    
}
