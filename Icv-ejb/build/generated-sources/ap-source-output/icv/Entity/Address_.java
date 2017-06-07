package icv.Entity;

import icv.Entity.District;
import icv.Entity.Profile;
import icv.Entity.Province;
import icv.Entity.Ward;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> address;
    public static volatile SingularAttribute<Address, District> districtid;
    public static volatile SingularAttribute<Address, Date> lastUpdate;
    public static volatile SingularAttribute<Address, Ward> wardid;
    public static volatile SingularAttribute<Address, Province> provinceid;
    public static volatile SingularAttribute<Address, Short> addressid;
    public static volatile CollectionAttribute<Address, Profile> profileCollection;

}