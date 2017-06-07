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
public class ExperiencesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short idUser;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short idSpecialized;

    public ExperiencesPK() {
    }

    public ExperiencesPK(short idUser, short idSpecialized) {
        this.idUser = idUser;
        this.idSpecialized = idSpecialized;
    }

    public short getIdUser() {
        return idUser;
    }

    public void setIdUser(short idUser) {
        this.idUser = idUser;
    }

    public short getIdSpecialized() {
        return idSpecialized;
    }

    public void setIdSpecialized(short idSpecialized) {
        this.idSpecialized = idSpecialized;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idSpecialized;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperiencesPK)) {
            return false;
        }
        ExperiencesPK other = (ExperiencesPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idSpecialized != other.idSpecialized) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.ExperiencesPK[ idUser=" + idUser + ", idSpecialized=" + idSpecialized + " ]";
    }
    
}
