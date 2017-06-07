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
    @NamedQuery(name = "Kindskill.findAll", query = "SELECT k FROM Kindskill k")
    , @NamedQuery(name = "Kindskill.findByIdkindskill", query = "SELECT k FROM Kindskill k WHERE k.idkindskill = :idkindskill")
    , @NamedQuery(name = "Kindskill.findByNamekindskill", query = "SELECT k FROM Kindskill k WHERE k.namekindskill = :namekindskill")
    , @NamedQuery(name = "Kindskill.findByNamekindshow", query = "SELECT k FROM Kindskill k WHERE k.namekindshow = :namekindshow")})
public class Kindskill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Short idkindskill;
    @Size(max = 100)
    @Column(length = 100)
    private String namekindskill;
    @Size(max = 50)
    @Column(length = 50)
    private String namekindshow;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idkindskill")
    private Collection<Skill> skillCollection;

    public Kindskill() {
    }

    public Kindskill(Short idkindskill) {
        this.idkindskill = idkindskill;
    }

    public Short getIdkindskill() {
        return idkindskill;
    }

    public void setIdkindskill(Short idkindskill) {
        this.idkindskill = idkindskill;
    }

    public String getNamekindskill() {
        return namekindskill;
    }

    public void setNamekindskill(String namekindskill) {
        this.namekindskill = namekindskill;
    }

    public String getNamekindshow() {
        return namekindshow;
    }

    public void setNamekindshow(String namekindshow) {
        this.namekindshow = namekindshow;
    }

    @XmlTransient
    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkindskill != null ? idkindskill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kindskill)) {
            return false;
        }
        Kindskill other = (Kindskill) object;
        if ((this.idkindskill == null && other.idkindskill != null) || (this.idkindskill != null && !this.idkindskill.equals(other.idkindskill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Kindskill[ idkindskill=" + idkindskill + " ]";
    }
    
}
