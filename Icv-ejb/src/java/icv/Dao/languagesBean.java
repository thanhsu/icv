
package icv.Dao;

import icv.Entity.Languages;
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
public class languagesBean {

    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Languages retriveLanguagesByName(String name){
        Query query = em.createNamedQuery("Languages.findByName");
        query.setParameter("name", name);
        
        return (Languages)query.getSingleResult();
    }

   
    
}
