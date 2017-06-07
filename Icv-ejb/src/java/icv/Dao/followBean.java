/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Followcv;
import icv.Entity.FollowcvPK;
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
public class followBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Followcv> retrivebyIdCv(Short idcv){
        try{
            Query query = em.createNamedQuery("Followcv.findByIdcv");
            query.setParameter("idcv", idcv);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Followcv> retrivebyIdUser(Short iduser){
        try{
            Query query = em.createNamedQuery("Followcv.findByIdUser");
            query.setParameter("idUser", iduser);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
    }
    
    public Followcv retrivebyIdUserIdCv(Short iduser, Short idcv){
        try{
            Query query = em.createNamedQuery("Followcv.findByIdcvIdUser");
                query.setParameter("idcv", idcv);
                query.setParameter("idUser", iduser);
             return (Followcv)query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Followcv> retriveAllbyIdCv(Short idcv){
        try{
            Query query = em.createNamedQuery("Followcv.findByIdcv");
            query.setParameter("idcv", idcv);
            
            return query.getResultList();
            
        }catch(Exception e){
            return null;
        }
    }
    
    public void updateRating(Followcv flc){
       // Query query = em.createNamedQuery("Followcv.update");
       // query.setParameter("rating", flc.getRating());
       // query.setParameter("followcvPK", flc.getFollowcvPK());
        
      //  query.executeUpdate();
      em.merge(flc);
    }
    public void deleteRating(Followcv fl){
        //em.remove(fl.getFollowcvPK());
        em.remove(this.retrivebyIdUserIdCv(fl.getFollowcvPK().getIdUser(), fl.getFollowcvPK().getIdcv()));
    }
    
    public void updateRating(Short idcv, Short idUser, Short ratting){
        FollowcvPK pk = new FollowcvPK(idcv, idUser);
        //em.merge(pk);
        Followcv flc = new Followcv(pk);
        flc.setRating(ratting);
        em.merge(flc);
    }
    
    public Followcv newFollowcv(Short iduser, Short idcv, Short rating){
        if(retrivebyIdUserIdCv(iduser, idcv)==null){
            Followcv fl; 
            FollowcvPK pk = new FollowcvPK(idcv, iduser);
            fl = new Followcv(pk);
            fl.setRating(rating);
            em.persist(fl);
            return fl;}
        else{
            Followcv fl = new Followcv(idcv, iduser);
            fl.setRating(rating);
            em.merge(fl);
            return fl;
        }
        
        
    }
    
}
