/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Skill;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author duyng
 */
@Stateless
@LocalBean
public class SkillBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Skill> retriveAllSkill(){
        return em.createNamedQuery("Skill.findAll").getResultList();
    }
    
    public void persistNewSkill(Skill skill){
        em.persist(skill);
    }
    
    public Skill getSkill(Short idSkill){
        try{
        Query query = em.createNamedQuery("Skill.findByIdSkill");
        query.setParameter("idSkill", idSkill);
        return (Skill) query.getSingleResult();}
        catch(Exception e){
            return null;
        }
    }
    
    public Skill getSkillbyDegreeAndname(Short degree, String name ){
        try{
        Query query = em.createNamedQuery("Skill.findByDegreeandName");
        query.setParameter("degree", degree);
        query.setParameter("name", name);
        return (Skill)query.getSingleResult();  }
        catch(Exception e){
            return null;
        }
    }
    
    public Skill getSkillbyDegreeAndnamekindskill(Short degree, String name , Short idKindskill){
        try{
            System.out.println("find: " +degree + name + idKindskill );
        Query query = em.createNamedQuery("Skill.findByDegreeNameandIdKindSkill");
        query.setParameter("degree", degree);
        query.setParameter("name", name);
        query.setParameter("idkindskill", idKindskill);
        return (Skill)query.getSingleResult();  }
        catch(Exception e){
            return null;
        }
    }
    
    public void updateSkill(Skill skill){
        em.merge(skill);
    }
    
    public void deleteSkill(Skill skill){
        em.remove(em.merge(skill));
    }


    
}
