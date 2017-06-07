package icv.Entity;

import icv.Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Boolean> allow;
    public static volatile SingularAttribute<Comment, User> idUser;
    public static volatile SingularAttribute<Comment, Integer> idComment;
    public static volatile SingularAttribute<Comment, String> content;

}