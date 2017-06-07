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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Cv.findAll", query = "SELECT c FROM Cv c")
    , @NamedQuery(name = "Cv.findByIdCV", query = "SELECT c FROM Cv c WHERE c.idCV = :idCV")
    , @NamedQuery(name = "Cv.searchbyCareer", query = "SELECT DISTINCT c FROM Cv c WHERE c.more LIKE :career")
    ,@NamedQuery(name = "Cv.findByIdStore", query="SELECT c FROM Cv c WHERE c.idStore.idStore = :idStore")
    , @NamedQuery(name = "Cv.findByVideoLink", query = "SELECT c FROM Cv c WHERE c.videoLink = :videoLink")})
public class Cv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short idCV;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String hobbit;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String activity;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String prize;
    @Lob
    @Size(max = 65535)
    @Column(name = "_References", length = 65535)
    private String references;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String more;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String targetJob;
    @Size(max = 200)
    @Column(length = 200)
    private String videoLink;
    @JoinColumn(name = "IdKind", referencedColumnName = "IdKind", nullable = false)
    @ManyToOne(optional = false)
    private Kindcv idKind;
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Languages languageId;
    @JoinColumn(name = "original_language_id", referencedColumnName = "id")
    @ManyToOne
    private Languages originalLanguageId;
    @JoinColumn(name = "IdStore", referencedColumnName = "IdStore", nullable = false)
    @ManyToOne(optional = false)
    private Storecv idStore;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<Cvmgmtskill> cvmgmtskillCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<Cvmgmteducation> cvmgmteducationCollection;

    public Cv() {
    }

    public Cv(Short idCV) {
        this.idCV = idCV;
    }

    public Short getIdCV() {
        return idCV;
    }

    public void setIdCV(Short idCV) {
        this.idCV = idCV;
    }

    public String getHobbit() {
        return hobbit;
    }

    public void setHobbit(String hobbit) {
        this.hobbit = hobbit;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getMore() {
        if(more== null){
            return " ";
        }
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getTargetJob() {
        return targetJob;
    }

    public void setTargetJob(String targetJob) {
        this.targetJob = targetJob;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Kindcv getIdKind() {
        return idKind;
    }

    public void setIdKind(Kindcv idKind) {
        this.idKind = idKind;
    }

    public Languages getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Languages languageId) {
        this.languageId = languageId;
    }

    public Languages getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Languages originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public Storecv getIdStore() {
        return idStore;
    }

    public void setIdStore(Storecv idStore) {
        this.idStore = idStore;
    }

    @XmlTransient
    public Collection<Cvmgmtskill> getCvmgmtskillCollection() {
        return cvmgmtskillCollection;
    }

    public void setCvmgmtskillCollection(Collection<Cvmgmtskill> cvmgmtskillCollection) {
        this.cvmgmtskillCollection = cvmgmtskillCollection;
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
        hash += (idCV != null ? idCV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cv)) {
            return false;
        }
        Cv other = (Cv) object;
        if ((this.idCV == null && other.idCV != null) || (this.idCV != null && !this.idCV.equals(other.idCV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Cv[ idCV=" + idCV + " ]";
    }
    
}
