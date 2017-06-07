package icv.Entity;

import icv.Entity.Address;
import icv.Entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Profile.class)
public class Profile_ { 

    public static volatile SingularAttribute<Profile, Short> idProfile;
    public static volatile SingularAttribute<Profile, Date> birthday;
    public static volatile SingularAttribute<Profile, String> lastName;
    public static volatile SingularAttribute<Profile, Boolean> sex;
    public static volatile SingularAttribute<Profile, String> description;
    public static volatile SingularAttribute<Profile, String> avatar;
    public static volatile SingularAttribute<Profile, String> hope;
    public static volatile SingularAttribute<Profile, Address> idAddress;
    public static volatile SingularAttribute<Profile, User> idUser;
    public static volatile SingularAttribute<Profile, String> firstName;
    public static volatile SingularAttribute<Profile, String> phone;
    public static volatile SingularAttribute<Profile, Date> lastUpdate;
    public static volatile SingularAttribute<Profile, String> email;

}