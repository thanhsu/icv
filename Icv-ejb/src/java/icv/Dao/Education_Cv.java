/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Education;
import icv.Entity.Cv;
import icv.Entity.Cvmgmteducation;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@LocalBean
public class Education_Cv {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    @EJB
    private EducationBean educationBean;

    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Cvmgmteducation> retriveAllbyIdCV(Short idcv){
        Query query = em.createNamedQuery("Cvmgmteducation.findByIdCV");
        query.setParameter("idCV", idcv);
        return query.getResultList();
    }
    
    public Cvmgmteducation retriveCv_EducationbyIdEducationIdCV(Short idcv, Short ideducation){
       try{ Query query = em.createNamedQuery("Cvmgmteducation.findByIdCVIdEducation");
            query.setParameter("idCV", idcv);
            query.setParameter("idEducation", ideducation);
            return (Cvmgmteducation)query.getSingleResult();}
       catch(Exception e){
           return null;
       }
    }
    public boolean removeEducationCvmgtEducation(Short idcv, Short ideducation){
        Cvmgmteducation cvmteducation = this.retriveCv_EducationbyIdEducationIdCV(idcv, ideducation);
        if(cvmteducation != null){
            em.remove(cvmteducation);
            return true;}
        else{
            return false;}
    }
    
    public void updateEducation(String tittle, String detail, String note, String period, Cv cv, String idEducation){
        Education education = educationBean.retriveById(idEducation);
            education.setDetail(detail);
            education.setNote(note);
            education.setTitile(tittle);
            em.merge(education);
        Cvmgmteducation mgmteducation = this.retriveCv_EducationbyIdEducationIdCV(cv.getIdCV(), Short.valueOf(education.getIdEducation().toString()));
            mgmteducation.setPeriodTime(period);
            em.merge(mgmteducation);
    }
    public boolean insertEducation(String tittle, String detail, String note){
        Education education = new Education(null, tittle);
        education.setDetail(detail);
        education.setNote(note);
        persist(education);
        return true;
    }
    
    public boolean insertMgmtEducation(String title, String detail, String period, String note,Cv cv ){
        Education education = educationBean.retriveEducationByTitleAndDetail(title, detail);
        
        Cvmgmteducation mgmteducation = new Cvmgmteducation(cv.getIdCV(), education.getIdEducation());
        
        mgmteducation.setPeriodTime(period);
        mgmteducation.setCv(cv);
        mgmteducation.setEducation(education);
        
        em.persist(mgmteducation);
        
        education.getCvmgmteducationCollection().add(mgmteducation);
        cv.getCvmgmteducationCollection().add(mgmteducation);
              
        return true;
    }

    
    
    
}
