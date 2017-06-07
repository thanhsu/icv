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
public class CvmgmtskillPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short idCV;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short idSkill;

    public CvmgmtskillPK() {
    }

    public CvmgmtskillPK(short idCV, short idSkill) {
        this.idCV = idCV;
        this.idSkill = idSkill;
    }

    public short getIdCV() {
        return idCV;
    }

    public void setIdCV(short idCV) {
        this.idCV = idCV;
    }

    public short getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(short idSkill) {
        this.idSkill = idSkill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCV;
        hash += (int) idSkill;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CvmgmtskillPK)) {
            return false;
        }
        CvmgmtskillPK other = (CvmgmtskillPK) object;
        if (this.idCV != other.idCV) {
            return false;
        }
        if (this.idSkill != other.idSkill) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.CvmgmtskillPK[ idCV=" + idCV + ", idSkill=" + idSkill + " ]";
    }
    
}
