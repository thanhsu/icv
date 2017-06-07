package icv.Entity;

import icv.Entity.Usergroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Authorization.class)
public class Authorization_ { 

    public static volatile CollectionAttribute<Authorization, Usergroup> usergroupCollection;
    public static volatile SingularAttribute<Authorization, String> name;
    public static volatile SingularAttribute<Authorization, Short> id;

}