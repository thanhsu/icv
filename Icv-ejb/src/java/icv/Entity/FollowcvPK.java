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
public class FollowcvPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short idcv;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short idUser;

    public FollowcvPK() {
    }

    public FollowcvPK(short idcv, short idUser) {
        this.idcv = idcv;
        this.idUser = idUser;
    }

    public short getIdcv() {
        return idcv;
    }

    public void setIdcv(short idcv) {
        this.idcv = idcv;
    }

    public short getIdUser() {
        return idUser;
    }

    public void setIdUser(short idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcv;
        hash += (int) idUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowcvPK)) {
            return false;
        }
        FollowcvPK other = (FollowcvPK) object;
        if (this.idcv != other.idcv) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.FollowcvPK[ idcv=" + idcv + ", idUser=" + idUser + " ]";
    }
    
}
