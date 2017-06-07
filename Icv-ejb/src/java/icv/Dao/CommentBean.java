/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;


import icv.Entity.Comment;
import icv.Entity.User;
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
public class CommentBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    
    public List<Comment> getAllComment(){
       return   em.createNamedQuery("Comment.findAll").getResultList();
    }
    
    public List<Comment> getAllCommentbyAllow(Boolean allow){
        try{
        Query query = em.createNamedQuery("Comment.findByAllow");
        query.setParameter("allow", allow);
        return query.getResultList();}
        catch(Exception e){
            return null;
        }
    }
    public Comment retriveByIdUser(User user){
       try{
            Query query = em.createNamedQuery("Comment.findByIdUser");
            query.setParameter("idUser", user.getIdUser());
            return (Comment)query.getSingleResult();
            
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Comment> retriveAllbyIdUserl(User user){
        try{
            Query query = em.createNamedQuery("Comment.findByIdUser");
            query.setParameter("idUser", user.getIdUser());
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
    }
    
    public void newComment(Comment cmt){
        if(this.retriveByIdUser(cmt.getIdUser()) == null){
            em.persist(cmt);
            em.flush();
        }else{
            Comment cmt2 = this.retriveByIdUser(cmt.getIdUser());
            cmt2.setContent(cmt.getContent());
            cmt2.setAllow(cmt.getAllow());
            em.merge(cmt2);
            
        }
        try{
        if(this.retriveAllbyIdUserl(cmt.getIdUser()).size() > 1){
            List<Comment> lst = this.retriveAllbyIdUserl(cmt.getIdUser());
            
            for(int i = 0 ; i< (lst.size() - 1);i++ ){
                em.remove(lst.get(i));
            }
            
        }}catch(Exception e){
            
        }
        
        
        
        
    }
    
    
    
}
