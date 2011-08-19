/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.interaction.domain.items.values;

import org.drools.interaction.domain.DomainAssociation;
import org.drools.interaction.domain.Value;

/**
 *
 * @author salaboy
 */
public class ObjectValue extends Value{
    private DomainAssociation association;
    private Object object;

    public ObjectValue(String itemId, Object object) {
        super(itemId);
        this.object = object;
    }
    
    public void setDomainAssociation(DomainAssociation association) {
        this.association = association;
    }

    public DomainAssociation getDomainAssociation() {
        return this.association;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    
    
    
}
