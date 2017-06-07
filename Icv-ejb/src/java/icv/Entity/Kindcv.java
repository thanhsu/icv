/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Kindcv.findAll", query = "SELECT k FROM Kindcv k")
    , @NamedQuery(name = "Kindcv.findByIdKind", query = "SELECT k FROM Kindcv k WHERE k.idKind = :idKind")
    , @NamedQuery(name = "Kindcv.findByName", query = "SELECT k FROM Kindcv k WHERE k.name = :name")})
public class Kindcv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(nullable = false)
    private Short idKind;
    @Size(max = 30)
    @Column(length = 30)
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String discussion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKind")
    private Collection<Cv> cvCollection;

    public Kindcv() {
    }

    public Kindcv(Short idKind) {
        this.idKind = idKind;
    }

    public Short getIdKind() {
        return idKind;
    }

    public void setIdKind(Short idKind) {
        this.idKind = idKind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
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
        hash += (idKind != null ? idKind.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kindcv)) {
            return false;
        }
        Kindcv other = (Kindcv) object;
        if ((this.idKind == null && other.idKind != null) || (this.idKind != null && !this.idKind.equals(other.idKind))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Kindcv[ idKind=" + idKind + " ]";
    }
    
}
