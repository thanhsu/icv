package icv.Entity;

import icv.Entity.Cv;
import icv.Entity.CvmgmtskillPK;
import icv.Entity.Skill;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-03T14:13:37")
@StaticMetamodel(Cvmgmtskill.class)
public class Cvmgmtskill_ { 

    public static volatile SingularAttribute<Cvmgmtskill, Cv> cv;
    public static volatile SingularAttribute<Cvmgmtskill, String> periodTime;
    public static volatile SingularAttribute<Cvmgmtskill, Skill> skill;
    public static volatile SingularAttribute<Cvmgmtskill, CvmgmtskillPK> cvmgmtskillPK;

}