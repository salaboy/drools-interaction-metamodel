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
public class DomainAssociation {
    private String id;
    private String clazz;
    private String field;
    private String type;

    public DomainAssociation() {
        this.id = UUID.randomUUID().toString();
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
            
}
