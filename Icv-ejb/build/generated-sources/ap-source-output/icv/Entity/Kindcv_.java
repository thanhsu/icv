package icv.Entity;

import icv.Entity.Cv;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Kindcv.class)
public class Kindcv_ { 

    public static volatile CollectionAttribute<Kindcv, Cv> cvCollection;
    public static volatile SingularAttribute<Kindcv, String> name;
    public static volatile SingularAttribute<Kindcv, String> discussion;
    public static volatile SingularAttribute<Kindcv, Short> idKind;

}