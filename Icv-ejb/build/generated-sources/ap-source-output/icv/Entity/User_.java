package icv.Entity;

import icv.Entity.Comment;
import icv.Entity.Experiences;
import icv.Entity.Profile;
import icv.Entity.Storecv;
import icv.Entity.Usergroup;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Short> idUser;
    public static volatile SingularAttribute<User, Usergroup> userGroupId;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Storecv> storecvCollection;
    public static volatile SingularAttribute<User, Date> lastUpdate;
    public static volatile CollectionAttribute<User, Comment> commentCollection;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile CollectionAttribute<User, Experiences> experiencesCollection;
    public static volatile CollectionAttribute<User, Profile> profileCollection;

}