/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid")
    , @NamedQuery(name = "Address.findByAddress", query = "SELECT a FROM Address a WHERE a.address = :address")
    , @NamedQuery(name = "Address.findByLastUpdate", query = "SELECT a FROM Address a WHERE a.lastUpdate = :lastUpdate")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short addressid;
    @Basic(optional = false)
    
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String address;
    @Basic(optional = false)

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @JoinColumn(name = "districtid", referencedColumnName = "districtid", nullable = false)
    @ManyToOne(optional = false)
    private District districtid;
    @JoinColumn(name = "WARDID", referencedColumnName = "wardid", nullable = false)
    @ManyToOne(optional = false)
    private Ward wardid;
    @JoinColumn(name = "provinceid", referencedColumnName = "provinceid", nullable = false)
    @ManyToOne(optional = false)
    private Province provinceid;
    @OneToMany(mappedBy = "idAddress")
    private Collection<Profile> profileCollection;

    public Address() {
    }

    public Address(Short addressid) {
        this.addressid = addressid;
    }

    public Address(Short addressid, String address, Date lastUpdate) {
        this.addressid = addressid;
        this.address = address;
        this.lastUpdate = lastUpdate;
    }

    public Short getAddressid() {
        return addressid;
    }

    public void setAddressid(Short addressid) {
        this.addressid = addressid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public District getDistrictid() {
        return districtid;
    }

    public void setDistrictid(District districtid) {
        this.districtid = districtid;
    }

    public Ward getWardid() {
        return wardid;
    }

    public void setWardid(Ward wardid) {
        this.wardid = wardid;
    }

    public Province getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Province provinceid) {
        this.provinceid = provinceid;
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Address[ addressid=" + addressid + " ]";
    }
    
}
