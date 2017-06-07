package icv.Entity;

import icv.Entity.Authorization;
import icv.Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Usergroup.class)
public class Usergroup_ { 

    public static volatile CollectionAttribute<Usergroup, Authorization> authorizationCollection;
    public static volatile CollectionAttribute<Usergroup, User> userCollection;
    public static volatile SingularAttribute<Usergroup, String> name;
    public static volatile SingularAttribute<Usergroup, Short> id;

}