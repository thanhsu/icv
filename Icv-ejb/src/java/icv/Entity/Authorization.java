/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Authorization.findAll", query = "SELECT a FROM Authorization a")
    , @NamedQuery(name = "Authorization.findById", query = "SELECT a FROM Authorization a WHERE a.id = :id")
    , @NamedQuery(name = "Authorization.findByName", query = "SELECT a FROM Authorization a WHERE a.name = :name")})
public class Authorization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Size(max = 50)
    @Column(length = 50)
    private String name;
    @JoinTable(name = "permissions", joinColumns = {
        @JoinColumn(name = "AuthorizationId", referencedColumnName = "Id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "UserGroupId", referencedColumnName = "Id", nullable = false)})
    @ManyToMany
    private Collection<Usergroup> usergroupCollection;

    public Authorization() {
    }

    public Authorization(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Usergroup> getUsergroupCollection() {
        return usergroupCollection;
    }

    public void setUsergroupCollection(Collection<Usergroup> usergroupCollection) {
        this.usergroupCollection = usergroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authorization)) {
            return false;
        }
        Authorization other = (Authorization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Authorization[ id=" + id + " ]";
    }
    
}
