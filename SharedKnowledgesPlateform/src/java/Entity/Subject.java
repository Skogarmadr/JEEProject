/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author florian.fasmeyer
 */
@Entity
@Table(name = "subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s")
    , @NamedQuery(name = "Subject.findBySubjectId", query = "SELECT s FROM Subject s WHERE s.subjectId = :subjectId")
    , @NamedQuery(name = "Subject.findByName", query = "SELECT s FROM Subject s WHERE s.name = :name")
    , @NamedQuery(name = "Subject.findByImg", query = "SELECT s FROM Subject s WHERE s.img = :img")
    , @NamedQuery(name = "Subject.findByDescription", query = "SELECT s FROM Subject s WHERE s.description = :description")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subject_id")
    private Integer subjectId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "description")
    private String description;

    public Subject() {
    }

    public Subject(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Subject(Integer subjectId, String name, String img, String description) {
        this.subjectId = subjectId;
        this.name = name;
        this.img = img;
        this.description = description;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectId != null ? subjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subjectId == null && other.subjectId != null) || (this.subjectId != null && !this.subjectId.equals(other.subjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Subject[ subjectId=" + subjectId + " ]";
    }
    
}
