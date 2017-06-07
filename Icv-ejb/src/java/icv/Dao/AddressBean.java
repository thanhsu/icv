/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Dao;

import icv.Entity.Address;
import icv.Entity.District;
import icv.Entity.Province;
import icv.Entity.Ward;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class AddressBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    

    public void persist(Object object) {
        em.persist(object);
    }

    public Address retriveAddressbyAddress(String address){
        try{
        Query query = em.createNamedQuery("Address.findByAddress");
        query.setParameter("address", address);
        return (Address) query.getSingleResult();}
        catch(Exception e ){
            return new Address(Short.valueOf("1"));
        }
    }
    
    public void InsertAddress(String address){

        District district = em.find(District.class, "001");
        Ward ward = em.find(Ward.class, "00001");
        Province province = em.find(Province.class,"01");
        
        Address add = new Address();
        add.setLastUpdate(new Date());
        add.setAddress(address);
        add.setDistrictid(district);
        add.setProvinceid(province);
        add.setWardid(ward);
        
        em.persist(add);
        em.flush();       
    }

  
    
}
