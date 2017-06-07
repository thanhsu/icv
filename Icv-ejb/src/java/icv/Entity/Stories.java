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
import javax.persistence.Lob;
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
@Table(catalog = "cvoffical", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stories.findAll", query = "SELECT s FROM Stories s")
    , @NamedQuery(name = "Stories.findByIdStories", query = "SELECT s FROM Stories s WHERE s.idStories = :idStories")
    , @NamedQuery(name = "Stories.findByTitle", query = "SELECT s FROM Stories s WHERE s.title = :title")
    , @NamedQuery(name = "Stories.findByDatepost", query = "SELECT s FROM Stories s WHERE s.datepost = :datepost")
    , @NamedQuery(name = "Stories.findByAccess", query = "SELECT s FROM Stories s WHERE s.access = :access")
    , @NamedQuery(name = "Stories.findBySignment", query = "SELECT s FROM Stories s WHERE s.signment = :signment")})
public class Stories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short idStories;
    @Size(max = 200)
    @Column(length = 200)
    private String title;
    @Size(max = 100)
    @Column(length = 100)
    private String datepost;
    private Boolean access;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String content;
    @Size(max = 100)
    @Column(length = 100)
    private String signment;

    public Stories() {
    }

    public Stories(Short idStories) {
        this.idStories = idStories;
    }

    public Short getIdStories() {
        return idStories;
    }

    public void setIdStories(Short idStories) {
        this.idStories = idStories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatepost() {
        return datepost;
    }

    public void setDatepost(String datepost) {
        this.datepost = datepost;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSignment() {
        return signment;
    }

    public void setSignment(String signment) {
        this.signment = signment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStories != null ? idStories.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stories)) {
            return false;
        }
        Stories other = (Stories) object;
        if ((this.idStories == null && other.idStories != null) || (this.idStories != null && !this.idStories.equals(other.idStories))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Stories[ idStories=" + idStories + " ]";
    }
    
}
