/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.interaction.domain.items.validation;

import java.util.UUID;

/**
 *
 * @author salaboy
 */
public class MissingValue {
    private String id;
    private String itemId;
    private String exchangeId;
    public MissingValue(String exchangeId, String itemId) {
        this.id = UUID.randomUUID().toString();
        this.exchangeId = exchangeId;
        this.itemId = itemId;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }
    
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    
}
