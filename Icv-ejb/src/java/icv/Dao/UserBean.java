/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Usergroup;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import icv.Entity.User;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author duyng
 */
@Stateless
@LocalBean
public class UserBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public boolean insertNewUser(String username, String password, Usergroup usergroup){
        
        Usergroup ugr = em.find(Usergroup.class, usergroup.getId());
        //em.getTransaction().begin();
        
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        
        user.setUserGroupId(ugr);
        user.setLastUpdate(new Date());
        
        em.persist(user);
        
        em.refresh(ugr);
        
        ugr.getUserCollection().add(user);
        
        return true;
    }
    public List<User> retriveAll(){
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    public User getUserbyUsernameAndPassword(String username, String password){
        try{
            
            System.out.println("Goto check loggin");
            Query query = em.createNamedQuery("User.findByUsernameandPassword");
            query.setParameter("Username", username);
            query.setParameter("password", password); 
            return (User)query.getSingleResult();
        }
        catch(Exception e){
            return null;
        }
    }
    
    public User getUserbyUsername(String username){
        try{
            Query query = em.createNamedQuery("User.findByUserName");
            query.setParameter("userName", username);
            
            return (User)query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    public  User getUserbyId(Short id){
        Query query = em.createNamedQuery("User.findByIdUser");
        query.setParameter("idUser", id);
        try{
            return (User)query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean updateUser(User user){
        em.merge(user);
        return true;
    }


}
