package icv.Entity;

import icv.Entity.Address;
import icv.Entity.District;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Province.class)
public class Province_ { 

    public static volatile CollectionAttribute<Province, Address> addressCollection;
    public static volatile CollectionAttribute<Province, District> districtCollection;
    public static volatile SingularAttribute<Province, String> name;
    public static volatile SingularAttribute<Province, String> type;
    public static volatile SingularAttribute<Province, String> provinceid;

}