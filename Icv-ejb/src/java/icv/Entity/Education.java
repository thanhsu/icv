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
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e")
    , @NamedQuery(name = "Education.findByTitileandDetail", query = "SELECT e FROM Education e WHERE e.titile = :title AND e.detail = :detail")
    , @NamedQuery(name = "Education.findByIdEducation", query = "SELECT e FROM Education e WHERE e.idEducation = :idEducation")
    , @NamedQuery(name = "Education.findByTitile", query = "SELECT e FROM Education e WHERE e.titile = :titile")
    , @NamedQuery(name = "Education.findByDetail", query = "SELECT e FROM Education e WHERE e.detail = :detail")
    , @NamedQuery(name = "Education.findByNote", query = "SELECT e FROM Education e WHERE e.note = :note")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idEducation;
    @Basic(optional = false)
    
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String titile;
    @Size(max = 300)
    @Column(length = 300)
    private String detail;
    @Size(max = 50)
    @Column(length = 50)
    private String note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "education")
    private Collection<Cvmgmteducation> cvmgmteducationCollection;

    public Education() {
    }

    public Education(Integer idEducation) {
        this.idEducation = idEducation;
    }

    public Education(Integer idEducation, String titile) {
        this.idEducation = idEducation;
        this.titile = titile;
    }

    public Integer getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(Integer idEducation) {
        this.idEducation = idEducation;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @XmlTransient
    public Collection<Cvmgmteducation> getCvmgmteducationCollection() {
        return cvmgmteducationCollection;
    }

    public void setCvmgmteducationCollection(Collection<Cvmgmteducation> cvmgmteducationCollection) {
        this.cvmgmteducationCollection = cvmgmteducationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEducation != null ? idEducation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.idEducation == null && other.idEducation != null) || (this.idEducation != null && !this.idEducation.equals(other.idEducation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Education[ idEducation=" + idEducation + " ]";
    }
    
}
