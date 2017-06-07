package icv.Entity;

import icv.Entity.Cvmgmteducation;
import icv.Entity.Cvmgmtskill;
import icv.Entity.Kindcv;
import icv.Entity.Languages;
import icv.Entity.Storecv;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Cv.class)
public class Cv_ { 

    public static volatile SingularAttribute<Cv, String> activity;
    public static volatile SingularAttribute<Cv, String> references;
    public static volatile CollectionAttribute<Cv, Cvmgmtskill> cvmgmtskillCollection;
    public static volatile SingularAttribute<Cv, String> more;
    public static volatile SingularAttribute<Cv, Languages> languageId;
    public static volatile CollectionAttribute<Cv, Cvmgmteducation> cvmgmteducationCollection;
    public static volatile SingularAttribute<Cv, String> prize;
    public static volatile SingularAttribute<Cv, String> targetJob;
    public static volatile SingularAttribute<Cv, String> hobbit;
    public static volatile SingularAttribute<Cv, String> videoLink;
    public static volatile SingularAttribute<Cv, Languages> originalLanguageId;
    public static volatile SingularAttribute<Cv, Storecv> idStore;
    public static volatile SingularAttribute<Cv, Kindcv> idKind;
    public static volatile SingularAttribute<Cv, Short> idCV;

}