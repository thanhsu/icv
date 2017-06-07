package icv.Entity;

import icv.Entity.ExperiencesPK;
import icv.Entity.Specialized;
import icv.Entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Experiences.class)
public class Experiences_ { 

    public static volatile SingularAttribute<Experiences, Specialized> specialized;
    public static volatile SingularAttribute<Experiences, ExperiencesPK> experiencesPK;
    public static volatile SingularAttribute<Experiences, Short> year;
    public static volatile SingularAttribute<Experiences, Date> lastUpdate;
    public static volatile SingularAttribute<Experiences, String> description;
    public static volatile SingularAttribute<Experiences, User> user;

}