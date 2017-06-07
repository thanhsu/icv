/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author duyng
 */
@Embeddable
public class CvmgmteducationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short idCV;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idEducation;

    public CvmgmteducationPK() {
    }

    public CvmgmteducationPK(short idCV, int idEducation) {
        this.idCV = idCV;
        this.idEducation = idEducation;
    }

    public short getIdCV() {
        return idCV;
    }

    public void setIdCV(short idCV) {
        this.idCV = idCV;
    }

    public int getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(int idEducation) {
        this.idEducation = idEducation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCV;
        hash += (int) idEducation;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CvmgmteducationPK)) {
            return false;
        }
        CvmgmteducationPK other = (CvmgmteducationPK) object;
        if (this.idCV != other.idCV) {
            return false;
        }
        if (this.idEducation != other.idEducation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.CvmgmteducationPK[ idCV=" + idCV + ", idEducation=" + idEducation + " ]";
    }
    
}
