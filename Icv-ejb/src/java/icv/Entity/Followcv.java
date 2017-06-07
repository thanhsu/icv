/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duyng
 */
@Entity
@Table(catalog = "cvoffical", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followcv.findAll", query = "SELECT f FROM Followcv f")
    , @NamedQuery(name = "Followcv.findByIdcvIdUser", query = "SELECT f FROM Followcv f WHERE f.followcvPK.idcv = :idcv AND f.followcvPK.idUser = :idUser")
    , @NamedQuery(name = "Followcv.findByIdcv", query = "SELECT f FROM Followcv f WHERE f.followcvPK.idcv = :idcv")
       ,@NamedQuery(name = "Followcv.update", query = "UPDATE Followcv f SET f.rating =:rating WHERE  f.followcvPK= :followcvPK")
        , @NamedQuery(name = "Followcv.findByIdUser", query = "SELECT f FROM Followcv f WHERE f.followcvPK.idUser = :idUser")
    , @NamedQuery(name = "Followcv.findByRating", query = "SELECT f FROM Followcv f WHERE f.rating = :rating")})
public class Followcv implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FollowcvPK followcvPK;
    private Short rating;

    public Followcv() {
    }

    public Followcv(FollowcvPK followcvPK) {
        this.followcvPK = followcvPK;
    }

    public Followcv(short idcv, short idUser) {
        this.followcvPK = new FollowcvPK(idcv, idUser);
    }

    public FollowcvPK getFollowcvPK() {
        return followcvPK;
    }

    public void setFollowcvPK(FollowcvPK followcvPK) {
        this.followcvPK = followcvPK;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followcvPK != null ? followcvPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followcv)) {
            return false;
        }
        Followcv other = (Followcv) object;
        if ((this.followcvPK == null && other.followcvPK != null) || (this.followcvPK != null && !this.followcvPK.equals(other.followcvPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Followcv[ followcvPK=" + followcvPK + " ]";
    }
    
}
