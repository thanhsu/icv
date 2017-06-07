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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Specialized.findAll", query = "SELECT s FROM Specialized s")
    , @NamedQuery(name = "Specialized.findByIdSpecialized", query = "SELECT s FROM Specialized s WHERE s.idSpecialized = :idSpecialized")
    , @NamedQuery(name = "Specialized.findByName", query = "SELECT s FROM Specialized s WHERE s.name = :name")})
public class Specialized implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short idSpecialized;
    @Basic(optional = false)
    
    @Size(min = 1, max = 25)
    @Column(nullable = false, length = 25)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialized")
    private Collection<Experiences> experiencesCollection;

    public Specialized() {
    }

    public Specialized(Short idSpecialized) {
        this.idSpecialized = idSpecialized;
    }

    public Specialized(Short idSpecialized, String name) {
        this.idSpecialized = idSpecialized;
        this.name = name;
    }

    public Short getIdSpecialized() {
        return idSpecialized;
    }

    public void setIdSpecialized(Short idSpecialized) {
        this.idSpecialized = idSpecialized;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Experiences> getExperiencesCollection() {
        return experiencesCollection;
    }

    public void setExperiencesCollection(Collection<Experiences> experiencesCollection) {
        this.experiencesCollection = experiencesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpecialized != null ? idSpecialized.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialized)) {
            return false;
        }
        Specialized other = (Specialized) object;
        if ((this.idSpecialized == null && other.idSpecialized != null) || (this.idSpecialized != null && !this.idSpecialized.equals(other.idSpecialized))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Specialized[ idSpecialized=" + idSpecialized + " ]";
    }
    
}
