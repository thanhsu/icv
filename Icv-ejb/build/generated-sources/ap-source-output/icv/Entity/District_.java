package icv.Entity;

import icv.Entity.Address;
import icv.Entity.Province;
import icv.Entity.Ward;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(District.class)
public class District_ { 

    public static volatile CollectionAttribute<District, Address> addressCollection;
    public static volatile SingularAttribute<District, String> districtid;
    public static volatile SingularAttribute<District, String> name;
    public static volatile SingularAttribute<District, String> location;
    public static volatile SingularAttribute<District, String> type;
    public static volatile CollectionAttribute<District, Ward> wardCollection;
    public static volatile SingularAttribute<District, Province> provinceid;

}