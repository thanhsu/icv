/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duyng
 */
@Entity
@Table(catalog = "cvoffical", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Storecv.findAll", query = "SELECT s FROM Storecv s")
    , @NamedQuery(name = "Storecv.findByIdStore", query = "SELECT s FROM Storecv s WHERE s.idStore = :idStore")
    , @NamedQuery(name = "Storecv.findByIdUser", query="SELECT s FROM Storecv s WHERE s.idUser.idUser = :idUser")
    , @NamedQuery(name = "Storecv.findByLastUpdate", query = "SELECT s FROM Storecv s WHERE s.lastUpdate = :lastUpdate")})
public class Storecv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short idStore;
    @Basic(optional = false)
 
    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @JoinColumn(name = "IdUser", referencedColumnName = "IdUser", nullable = false)
    @ManyToOne(optional = false)
    private User idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStore")
    private Collection<Cv> cvCollection;

    public Storecv() {
    }

    public Storecv(Short idStore) {
        this.idStore = idStore;
    }

    public Storecv(Short idStore, Date lastUpdate) {
        this.idStore = idStore;
        this.lastUpdate = lastUpdate;
    }

    public Short getIdStore() {
        return idStore;
    }

    public void setIdStore(Short idStore) {
        this.idStore = idStore;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public Collection<Cv> getCvCollection() {
        return cvCollection;
    }

    public void setCvCollection(Collection<Cv> cvCollection) {
        this.cvCollection = cvCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStore != null ? idStore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storecv)) {
            return false;
        }
        Storecv other = (Storecv) object;
        if ((this.idStore == null && other.idStore != null) || (this.idStore != null && !this.idStore.equals(other.idStore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Storecv[ idStore=" + idStore + " ]";
    }
    
}
