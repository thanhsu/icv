/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duyng
 */
@Entity
@Table(catalog = "cvoffical", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cvmgmtskill.findAll", query = "SELECT c FROM Cvmgmtskill c")
    , @NamedQuery(name = "Cvmgmtskill.findByIdCV", query = "SELECT c FROM Cvmgmtskill c WHERE c.cvmgmtskillPK.idCV = :idCV")
    , @NamedQuery(name ="Cvmgmtskill.findByIdCVandIdSkill", query ="SELECT c FROM Cvmgmtskill c WHERE c.cv.idCV = :idCV AND c.skill.idSkill = :idSkill" )
    , @NamedQuery(name = "Cvmgmtskill.findByIdSkill", query = "SELECT c FROM Cvmgmtskill c WHERE c.cvmgmtskillPK.idSkill = :idSkill")})
public class Cvmgmtskill implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CvmgmtskillPK cvmgmtskillPK;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String periodTime;
    @JoinColumn(name = "IdSkill", referencedColumnName = "idSkill", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Skill skill;
    @JoinColumn(name = "IdCV", referencedColumnName = "IdCV", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cv cv;

    public Cvmgmtskill() {
    }

    public Cvmgmtskill(CvmgmtskillPK cvmgmtskillPK) {
        this.cvmgmtskillPK = cvmgmtskillPK;
    }

    public Cvmgmtskill(short idCV, short idSkill) {
        this.cvmgmtskillPK = new CvmgmtskillPK(idCV, idSkill);
    }

    public CvmgmtskillPK getCvmgmtskillPK() {
        return cvmgmtskillPK;
    }

    public void setCvmgmtskillPK(CvmgmtskillPK cvmgmtskillPK) {
        this.cvmgmtskillPK = cvmgmtskillPK;
    }

    public String getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(String periodTime) {
        this.periodTime = periodTime;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cvmgmtskillPK != null ? cvmgmtskillPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cvmgmtskill)) {
            return false;
        }
        Cvmgmtskill other = (Cvmgmtskill) object;
        if ((this.cvmgmtskillPK == null && other.cvmgmtskillPK != null) || (this.cvmgmtskillPK != null && !this.cvmgmtskillPK.equals(other.cvmgmtskillPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Cvmgmtskill[ cvmgmtskillPK=" + cvmgmtskillPK + " ]";
    }
    
}
