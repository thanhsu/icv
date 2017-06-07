/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import icv.Entity.Usergroup;
import javax.persistence.Query;
/**
 *
 * @author duyng
 */
@Stateless
@LocalBean
public class GroupBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Usergroup> retriveAllUserGroup(){
        return em.createNamedQuery("Usergroup.findAll").getResultList();
    }
    
    public Usergroup persistUsergroup(Usergroup usergroup){
        em.persist(usergroup);
        return usergroup;
    }
    
    public Usergroup retriveUserGroupByName(String name){
        Query query = em.createNamedQuery("Usergroup.findByName");
        query.setParameter("name", name);
        return (Usergroup)query.getSingleResult();
    }
    public Usergroup retriveUserGroupById(Short id){
        Query query = em.createNamedQuery("Usergroup.findById");
        query.setParameter("id", id);
        return (Usergroup)query.getSingleResult();
    }

    public void persist1(Object object) {
        em.persist(object);
    }
    
}
