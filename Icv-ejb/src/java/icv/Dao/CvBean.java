
package icv.Dao;

import icv.Entity.Cv;
import icv.Entity.Kindcv;
import icv.Entity.Languages;
import icv.Entity.Storecv;
import icv.Entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@LocalBean
public class CvBean {

    @EJB
    private KindcvBean kindcvBean;

    @EJB
    private languagesBean languagesBean;
    @PersistenceContext(unitName = "Icv-ejbPU")
    private EntityManager em;

    @EJB
    private User_cv user_cv;

    

    public void persist(Object object) {
        em.persist(object);
    }

    public Cv retriveCVbyIdStore(Storecv store){
        Query query = em.createNamedQuery("Cv.findByIdStore");
        query.setParameter("idStore", store.getIdStore());
        
        return (Cv)query.getSingleResult();
    }
    
    public Cv retriveCVbyIdCV(Short idcv){
        Query query = em.createNamedQuery("Cv.findByIdCV");
        query.setParameter("idCV", idcv);
        return (Cv)query.getSingleResult();
        
    }
    
    public Cv persistNewCv(Cv cv){
        em.persist(cv);
        return cv;
    }
    
    public boolean InsertStoreCv(Cv cv, User user, String namekindcv, String nameoriginallg, String nameLanguahes){
        Storecv storecv = user_cv.retriveStoreCvbyIdUser(user.getIdUser());
        cv.setIdStore(storecv);
        
        Kindcv kindcv = kindcvBean.retriveKindcvbyName(namekindcv);
        cv.setIdKind(kindcv);
        
        Languages languages1 = languagesBean.retriveLanguagesByName(nameoriginallg);
        cv.setOriginalLanguageId(languages1);
        
        Languages languages2 = languagesBean.retriveLanguagesByName(nameLanguahes);
        cv.setLanguageId(languages2);
        
        em.persist(cv);
        storecv.getCvCollection().add(cv);
        
        
        
        return true;
    }
    
    public void newRegisterCv(User user, Storecv store, String path){
        Cv cv= new Cv();
        Languages languages1 = languagesBean.retriveLanguagesByName("English");
        cv.setActivity("");
        cv.setHobbit("");
        cv.setIdKind(kindcvBean.retriveKindcvbyName("Kind1"));
        cv.setIdStore(store);
        cv.setLanguageId(languages1);
        cv.setMore("");
        cv.setOriginalLanguageId(languages1);
        cv.setPrize("");
        cv.setReferences(path);
        cv.setTargetJob("");
        cv.setVideoLink("");
        
        em.persist(cv);
        
        
    }
    
    public List<Cv> searchbyCareer(String career){
        Query query = em.createNamedQuery("Cv.searchbyCareer");
        query.setParameter("career", "%" + career + "%");
        try{
            return  query.getResultList();
        }catch(Exception e){
            return null;
        }
        
        
    }
    
    public void UpdateCv(Cv cv){
        em.merge(cv);
    }
    
    public void DeleteCv(Cv  cv){
        em.remove(em.merge(cv));
    }

   
}
