package icv.Entity;

import icv.Entity.Cvmgmteducation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Education.class)
public class Education_ { 

    public static volatile SingularAttribute<Education, String> note;
    public static volatile SingularAttribute<Education, String> titile;
    public static volatile SingularAttribute<Education, Integer> idEducation;
    public static volatile CollectionAttribute<Education, Cvmgmteducation> cvmgmteducationCollection;
    public static volatile SingularAttribute<Education, String> detail;

}