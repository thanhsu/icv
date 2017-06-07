package icv.Entity;

import icv.Entity.Address;
import icv.Entity.District;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Ward.class)
public class Ward_ { 

    public static volatile CollectionAttribute<Ward, Address> addressCollection;
    public static volatile SingularAttribute<Ward, District> districtid;
    public static volatile SingularAttribute<Ward, String> name;
    public static volatile SingularAttribute<Ward, String> location;
    public static volatile SingularAttribute<Ward, String> wardid;
    public static volatile SingularAttribute<Ward, String> type;

}