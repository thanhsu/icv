package icv.Entity;

import icv.Entity.Skill;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Kindskill.class)
public class Kindskill_ { 

    public static volatile SingularAttribute<Kindskill, String> namekindshow;
    public static volatile SingularAttribute<Kindskill, String> namekindskill;
    public static volatile CollectionAttribute<Kindskill, Skill> skillCollection;
    public static volatile SingularAttribute<Kindskill, Short> idkindskill;

}