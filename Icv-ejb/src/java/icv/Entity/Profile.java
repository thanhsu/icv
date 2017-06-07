/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icv.Entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
    , @NamedQuery(name = "Profile.findByIdUser", query = "SELECT p FROM Profile p WHERE p.idUser.idUser = :iduser")
    , @NamedQuery(name = "Profile.findByIdProfile", query = "SELECT p FROM Profile p WHERE p.idProfile = :idProfile")
    , @NamedQuery(name = "Profile.findByFirstName", query = "SELECT p FROM Profile p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Profile.searchByName", query = "SELECT DISTINCT p FROM Profile p WHERE ( p.firstName LIKE :firstName) OR (p.lastName LIKE :lastName)")
    , @NamedQuery(name = "Profile.findByLastName", query = "SELECT p FROM Profile p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Profile.findByBirthday", query = "SELECT p FROM Profile p WHERE p.birthday = :birthday")
    , @NamedQuery(name = "Profile.findByPhone", query = "SELECT p FROM Profile p WHERE p.phone = :phone")
    , @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email")
    , @NamedQuery(name = "Profile.findByAvatar", query = "SELECT p FROM Profile p WHERE p.avatar = :avatar")
    , @NamedQuery(name = "Profile.findByLastUpdate", query = "SELECT p FROM Profile p WHERE p.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "Profile.findBySex", query = "SELECT p FROM Profile p WHERE p.sex = :sex")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short idProfile;
    @Basic(optional = false)
    
    @Size(min = 1, max = 45)
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic(optional = false)

    @Size(min = 1, max = 45)
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(length = 15)
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(length = 50)
    private String email;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String hope;
    @Size(max = 10)
    @Column(length = 10)
    private String avatar;
    @Basic(optional = false)

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    private Boolean sex;
    @JoinColumn(name = "IdAddress", referencedColumnName = "addressid")
    @ManyToOne
    private Address idAddress;
    @JoinColumn(name = "IdUser", referencedColumnName = "IdUser", nullable = false)
    @ManyToOne(optional = false)
    private User idUser;

    public Profile() {
    }

    public Profile(Short idProfile) {
        this.idProfile = idProfile;
    }

    public Profile(Short idProfile, String firstName, String lastName, Date lastUpdate) {
        this.idProfile = idProfile;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Short getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Short idProfile) {
        this.idProfile = idProfile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        try{
            Calendar cal = Calendar.getInstance();
            cal.setTime(birthday);
            System.out.println(cal.toString());
            String str = ""+cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.YEAR);
            return str;}
        catch(Exception e){
            return " ";
        }
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHope() {
        return hope;
    }

    public void setHope(String hope) {
        this.hope = hope;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getSex() {
        try{
        if(sex == true){
            return "Male";
        }else
            return "Female";}
        catch(Exception e){
            return "";
        }
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfile != null ? idProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.idProfile == null && other.idProfile != null) || (this.idProfile != null && !this.idProfile.equals(other.idProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Profile[ idProfile=" + idProfile + " ]";
    }
    
}
