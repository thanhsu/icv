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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Ward.findAll", query = "SELECT w FROM Ward w")
    , @NamedQuery(name = "Ward.findByWardid", query = "SELECT w FROM Ward w WHERE w.wardid = :wardid")
    , @NamedQuery(name = "Ward.findByName", query = "SELECT w FROM Ward w WHERE w.name = :name")
    , @NamedQuery(name = "Ward.findByType", query = "SELECT w FROM Ward w WHERE w.type = :type")
    , @NamedQuery(name = "Ward.findByLocation", query = "SELECT w FROM Ward w WHERE w.location = :location")})
public class Ward implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(nullable = false, length = 5)
    private String wardid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wardid")
    private Collection<Address> addressCollection;
    @JoinColumn(name = "districtid", referencedColumnName = "districtid", nullable = false)
    @ManyToOne(optional = false)
    private District districtid;

    public Ward() {
    }

    public Ward(String wardid) {
        this.wardid = wardid;
    }

    public Ward(String wardid, String name, String type, String location) {
        this.wardid = wardid;
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public String getWardid() {
        return wardid;
    }

    public void setWardid(String wardid) {
        this.wardid = wardid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    public District getDistrictid() {
        return districtid;
    }

    public void setDistrictid(District districtid) {
        this.districtid = districtid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wardid != null ? wardid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ward)) {
            return false;
        }
        Ward other = (Ward) object;
        if ((this.wardid == null && other.wardid != null) || (this.wardid != null && !this.wardid.equals(other.wardid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Ward[ wardid=" + wardid + " ]";
    }
    
}
