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
    @NamedQuery(name = "Cvmgmteducation.findAll", query = "SELECT c FROM Cvmgmteducation c")
    , @NamedQuery(name = "Cvmgmteducation.findByIdCV", query = "SELECT c FROM Cvmgmteducation c WHERE c.cvmgmteducationPK.idCV = :idCV")
        , @NamedQuery(name = "Cvmgmteducation.findByIdCVIdEducation", query ="SELECT c FROM Cvmgmteducation c WHERE c.cvmgmteducationPK.idCV = :idCV AND c.cvmgmteducationPK.idEducation = :idEducation")
    , @NamedQuery(name = "Cvmgmteducation.findByIdEducation", query = "SELECT c FROM Cvmgmteducation c WHERE c.cvmgmteducationPK.idEducation = :idEducation")})
public class Cvmgmteducation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CvmgmteducationPK cvmgmteducationPK;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String periodTime;
    @JoinColumn(name = "idEducation", referencedColumnName = "idEducation", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Education education;
    @JoinColumn(name = "IdCV", referencedColumnName = "IdCV", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cv cv;

    public Cvmgmteducation() {
    }

    public Cvmgmteducation(CvmgmteducationPK cvmgmteducationPK) {
        this.cvmgmteducationPK = cvmgmteducationPK;
    }

    public Cvmgmteducation(short idCV, int idEducation) {
        this.cvmgmteducationPK = new CvmgmteducationPK(idCV, idEducation);
    }

    public CvmgmteducationPK getCvmgmteducationPK() {
        return cvmgmteducationPK;
    }

    public void setCvmgmteducationPK(CvmgmteducationPK cvmgmteducationPK) {
        this.cvmgmteducationPK = cvmgmteducationPK;
    }

    public String getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(String periodTime) {
        this.periodTime = periodTime;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
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
        hash += (cvmgmteducationPK != null ? cvmgmteducationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cvmgmteducation)) {
            return false;
        }
        Cvmgmteducation other = (Cvmgmteducation) object;
        if ((this.cvmgmteducationPK == null && other.cvmgmteducationPK != null) || (this.cvmgmteducationPK != null && !this.cvmgmteducationPK.equals(other.cvmgmteducationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Cvmgmteducation[ cvmgmteducationPK=" + cvmgmteducationPK + " ]";
    }
    
}
