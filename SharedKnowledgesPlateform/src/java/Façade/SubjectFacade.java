/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Façade;

import Entity.Subject;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author florian.fasmeyer
 */
@Stateless
public class SubjectFacade extends AbstractFacade<Subject> implements SubjectFacadeLocal {

    @PersistenceContext(unitName = "SharedKnowledgesPlateformPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubjectFacade() {
        super(Subject.class);
    }
    
}
