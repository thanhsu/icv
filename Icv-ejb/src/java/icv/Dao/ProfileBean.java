/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Address;
import icv.Entity.Profile;
import icv.Entity.User;
import java.util.Date;
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
public class ProfileBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Profile> retriveAllProfile(){
        try{
        return em.createNamedQuery("Profile.findAll").getResultList();}
        catch(Exception e){
            return null;
        }
    }
    
    public boolean insertProfile(User user, Address address, String firstname, String lastname, Date birthday,String phonenumber, String email,String description, String hope, String Avatar ){
        
        User _user = em.find(User.class, user.getIdUser());
        Address add = em.find(Address.class, address.getAddressid());
        
        Profile profile = new Profile(null, firstname, lastname,null);
            profile.setBirthday(birthday);
            if(Avatar.equals("")){
                profile.setAvatar("non.jpg");
            }else{
                profile.setAvatar(Avatar);
            }
            profile.setDescription(description);
            profile.setEmail(email);
            
            profile.setIdAddress(add);
            
            profile.setIdUser(_user);
           
            profile.setPhone(phonenumber);
           
            em.persist(profile);
            em.flush();
            em.refresh(_user);
            
            _user.getProfileCollection().add(profile);
            
        return true;
    }
    
    public Profile retriveProfileByIdUser(Short iduser){
        try{
        Query query = em.createNamedQuery("Profile.findByIdUser");
        query.setParameter("iduser", iduser);
        
        return (Profile)query.getSingleResult();}
        catch(Exception e){
            return null;
        }
    }
    
    public List<Profile> searchByName(String key){
        try{
            Query query = em.createNamedQuery("Profile.searchByName");
            query.setParameter("firstName", "%"+key+"%");
            query.setParameter("lastName", "%"+key+"%");
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
        
    }
    
    public boolean updateProfile( Profile profile ){
        em.merge(profile);
        return true;
    }

}
