package icv.Entity;

import icv.Entity.Experiences;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Specialized.class)
public class Specialized_ { 

    public static volatile SingularAttribute<Specialized, String> name;
    public static volatile SingularAttribute<Specialized, Short> idSpecialized;
    public static volatile CollectionAttribute<Specialized, Experiences> experiencesCollection;

}