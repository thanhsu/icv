package icv.Entity;

import icv.Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Storeimage.class)
public class Storeimage_ { 

    public static volatile SingularAttribute<Storeimage, User> idUser;
    public static volatile SingularAttribute<Storeimage, String> note;
    public static volatile SingularAttribute<Storeimage, Short> idImage;
    public static volatile SingularAttribute<Storeimage, byte[]> imagevalue;
    public static volatile SingularAttribute<Storeimage, Short> typeImage;

}