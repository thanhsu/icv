/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duyng
 */
@Entity
@Table(name = "skill", catalog = "cvoffical", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s")
    , @NamedQuery(name = "Skill.findByIdSkill", query = "SELECT s FROM Skill s WHERE s.idSkill = :idSkill")
    , @NamedQuery(name = "Skill.findByDegree", query = "SELECT s FROM Skill s WHERE s.degree = :degree")
    , @NamedQuery(name = "Skill.findByDegreeandName", query="SELECT s FROM Skill s WHERE s.degree = :degree AND s.name = :name")
    , @NamedQuery(name = "Skill.findByDegreeNameandIdKindSkill", query = "SELECT s FROM Skill s WHERE s.degree = :degree AND s.name = :name AND s.idkindskill.idkindskill = :idkindskill")    
    , @NamedQuery(name = "Skill.findByName", query = "SELECT s FROM Skill s WHERE s.name = :name")})
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short idSkill;
    @Basic(optional = false)
 
    @Column(nullable = false)
    private Short degree;
    @Basic(optional = false)

    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 20)
    private String name;
    @JoinColumn(name = "idkindskill", referencedColumnName = "idkindskill", nullable = false)
    @ManyToOne(optional = false)
    private Kindskill idkindskill;

    public Skill() {
    }

    public Skill(Short idSkill) {
        this.idSkill = idSkill;
    }

    public Skill(Short idSkill, Short degree, String name) {
        this.idSkill = idSkill;
        this.degree = degree;
        this.name = name;
    }

    public Short getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Short idSkill) {
        this.idSkill = idSkill;
    }

    public Short getDegree() {
        return degree;
    }

    public void setDegree(Short degree) {
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kindskill getIdkindskill() {
        return idkindskill;
    }

    public void setIdkindskill(Kindskill idkindskill) {
        this.idkindskill = idkindskill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSkill != null ? idSkill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.idSkill == null && other.idSkill != null) || (this.idSkill != null && !this.idSkill.equals(other.idSkill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Skill_1[ idSkill=" + idSkill + " ]";
    }
    
}
