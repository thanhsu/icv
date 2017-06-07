/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Skill;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import icv.Entity.Cv;
import icv.Entity.Cvmgmtskill;
import icv.Entity.Kindskill;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Query;

/**
 *
 * @author duyng
 */
@Stateless
@LocalBean
public class Cv_Skill {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    @EJB
    private SkillBean skillBean;

    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Kindskill retriveKindSkillbyid(Short idskill){
        try{
        Query query = em.createNamedQuery("Kindskill.findByIdkindskill");
        query.setParameter("idkindskill", idskill);
        return (Kindskill)query.getSingleResult();}
        catch(Exception e){
            return null;
        }
    }
    
    public Cvmgmtskill retrivebyIdCvandIdSkill(Short idskill, Short idCv){
        try{
            Query query = em.createNamedQuery("Cvmgmtskill.findByIdCVandIdSkill");
            query.setParameter("idCV", idCv);
            query.setParameter("idSkill", idskill);
            return(Cvmgmtskill) query.getSingleResult();
        }catch(Exception e){return null;}
    }
    
    public List<Cvmgmtskill> retriveAllbyIdCv(Short idCv){
        Query query = em.createNamedQuery("Cvmgmtskill.findByIdCV");
        query.setParameter("idCV", idCv);
        return query.getResultList();
    }
    
    public boolean insertSkill(String name, Short degree, Short idkindskill){
        Skill skill = new Skill();
        skill.setDegree(degree);
        skill.setName(name);
        skill.setIdkindskill(this.retriveKindSkillbyid(idkindskill));
        em.persist(skill);
        return true;
    }
    
    public boolean removeSkillCv(Short idskill,Cv cv){
        Cvmgmtskill cvskill = this.retrivebyIdCvandIdSkill(idskill, cv.getIdCV());
        //System.out.println( "found cvmgmtskill : " + cvskill.getPeriodTime());
        em.remove(cvskill);
        return true;
    }
    
    public void updatemnmmentSkill(Cvmgmtskill cvmg){
        em.merge(cvmg);
    }
    
    public boolean insertMngmentSkill(String name, Short degree, Cv cv, String periodtime, Short idkindSkill ){
        Skill skill = skillBean.getSkillbyDegreeAndnamekindskill(degree, name,idkindSkill);
        
        
        
        Cvmgmtskill mgmtskill = this.retrivebyIdCvandIdSkill(skill.getIdSkill(), cv.getIdCV());
        if(mgmtskill==null){
        mgmtskill = new Cvmgmtskill(cv.getIdCV(), skill.getIdSkill());
        mgmtskill.setPeriodTime(periodtime);
        mgmtskill.setCv(cv);
        mgmtskill.setSkill(skill);
        
        em.persist(mgmtskill);
        cv.getCvmgmtskillCollection().add(mgmtskill);
        }else{
            mgmtskill.setPeriodTime(periodtime);
            em.merge(mgmtskill);
        }
        return true;
    }

    
   
    
}
