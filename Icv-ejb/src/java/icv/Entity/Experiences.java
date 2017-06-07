/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duyng
 */
@Entity
@Table(catalog = "cvoffical", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiences.findAll", query = "SELECT e FROM Experiences e")
    , @NamedQuery(name = "Experiences.findByIdSpecializedIdUser", query ="SELECT e FROM Experiences e WHERE e.experiencesPK.idSpecialized = :idSpecialized AND e.experiencesPK.idUser = :idUser")
    , @NamedQuery(name = "Experiences.findByIdUser", query = "SELECT e FROM Experiences e WHERE e.user.idUser = :idUser")
    , @NamedQuery(name = "Experiences.findByIdSpecialized", query = "SELECT e FROM Experiences e WHERE e.experiencesPK.idSpecialized = :idSpecialized")
    , @NamedQuery(name = "Experiences.findByYear", query = "SELECT e FROM Experiences e WHERE e.year = :year")
    , @NamedQuery(name = "Experiences.findByLastUpdate", query = "SELECT e FROM Experiences e WHERE e.lastUpdate = :lastUpdate")})
public class Experiences implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExperiencesPK experiencesPK;
    @Basic(optional = false)

    @Column(name = "_year", nullable = false)
    private short year;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String description;
    @Basic(optional = false)

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @JoinColumn(name = "idSpecialized", referencedColumnName = "idSpecialized", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Specialized specialized;
    @JoinColumn(name = "IdUser", referencedColumnName = "IdUser", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Experiences() {
    }

    public Experiences(ExperiencesPK experiencesPK) {
        this.experiencesPK = experiencesPK;
    }

    public Experiences(ExperiencesPK experiencesPK, short year, Date lastUpdate) {
        this.experiencesPK = experiencesPK;
        this.year = year;
        this.lastUpdate = lastUpdate;
    }

    public Experiences(short idUser, short idSpecialized) {
        this.experiencesPK = new ExperiencesPK(idUser, idSpecialized);
    }

    public ExperiencesPK getExperiencesPK() {
        return experiencesPK;
    }

    public void setExperiencesPK(ExperiencesPK experiencesPK) {
        this.experiencesPK = experiencesPK;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Specialized getSpecialized() {
        return specialized;
    }

    public void setSpecialized(Specialized specialized) {
        this.specialized = specialized;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (experiencesPK != null ? experiencesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiences)) {
            return false;
        }
        Experiences other = (Experiences) object;
        if ((this.experiencesPK == null && other.experiencesPK != null) || (this.experiencesPK != null && !this.experiencesPK.equals(other.experiencesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Experiences[ experiencesPK=" + experiencesPK + " ]";
    }
    
}
