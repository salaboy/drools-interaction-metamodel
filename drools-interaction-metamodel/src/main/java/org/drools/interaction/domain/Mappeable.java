/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.interaction.domain;

/**
 *
 * @author salaboy
 */
public interface Mappeable {
    public void setDomainAssociation(DomainAssociation association);
    public DomainAssociation getDomainAssociation();
}
