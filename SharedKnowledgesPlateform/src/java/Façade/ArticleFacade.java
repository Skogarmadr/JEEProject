/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Façade;

import Entity.Article;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author florian.fasmeyer
 */
@Stateless
public class ArticleFacade extends AbstractFacade<Article> implements ArticleFacadeLocal {

    @PersistenceContext(unitName = "SharedKnowledgesPlateformPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
    
    //Exemple
    public Article ArticleByDate(){
        /* 
        em.CreateNamedQuerrs() permet d'appeler des requêtes existantes dans
        entity. Une requête SQL renvoi une liste.
        (List<Manufacturer>)em.createNamedQuery("Manufacturer.findAll");
        */
        return ((List<Article>)em.createNamedQuery("Article.findAll")).get(0);
    }
}
