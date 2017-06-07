package icv.Entity;

import icv.Entity.Cv;
import icv.Entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Storecv.class)
public class Storecv_ { 

    public static volatile SingularAttribute<Storecv, User> idUser;
    public static volatile CollectionAttribute<Storecv, Cv> cvCollection;
    public static volatile SingularAttribute<Storecv, Date> lastUpdate;
    public static volatile SingularAttribute<Storecv, Short> idStore;

}