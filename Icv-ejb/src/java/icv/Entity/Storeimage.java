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
import javax.persistence.Lob;
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
@Table(catalog = "cvoffical", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Storeimage.findAll", query = "SELECT s FROM Storeimage s")
    , @NamedQuery(name = "Storeimage.findByIdImage", query = "SELECT s FROM Storeimage s WHERE s.idImage = :idImage")
    , @NamedQuery(name = "Storeimage.findByNote", query = "SELECT s FROM Storeimage s WHERE s.note = :note")
    , @NamedQuery(name = "Storeimage.findByIdUser", query = "SELECT s From Storeimage s WHERE s.idUser.idUser = :IdUser")
    , @NamedQuery(name = "Storeimage.findByTypeImage", query = "SELECT s FROM Storeimage s WHERE s.typeImage = :typeImage")})
public class Storeimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short idImage;
    @Lob
    private byte[] imagevalue;
    @Size(max = 100)
    @Column(length = 100)
    private String note;
    private Short typeImage;
    @JoinColumn(name = "IdUser", referencedColumnName = "IdUser", nullable = false)
    @ManyToOne(optional = false)
    private User idUser;

    public Storeimage() {
    }

    public Storeimage(Short idImage) {
        this.idImage = idImage;
    }

    public Short getIdImage() {
        return idImage;
    }

    public void setIdImage(Short idImage) {
        this.idImage = idImage;
    }

    public byte[] getImagevalue() {
        return imagevalue;
    }

    public void setImagevalue(byte[] imagevalue) {
        this.imagevalue = imagevalue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Short getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(Short typeImage) {
        this.typeImage = typeImage;
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
        hash += (idImage != null ? idImage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storeimage)) {
            return false;
        }
        Storeimage other = (Storeimage) object;
        if ((this.idImage == null && other.idImage != null) || (this.idImage != null && !this.idImage.equals(other.idImage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icv.Entity.Storeimage[ idImage=" + idImage + " ]";
    }
    
}
