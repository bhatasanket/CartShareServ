/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

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
 * @author it354f701
 */
@Entity
@Table(name = "IT354_sanket.SHOPPINGLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppinglist.findAll", query = "SELECT s FROM Shoppinglist s"),
    @NamedQuery(name = "Shoppinglist.findById", query = "SELECT s FROM Shoppinglist s WHERE s.id = :id"),
    @NamedQuery(name = "Shoppinglist.findByGroupname", query = "SELECT s FROM Shoppinglist s WHERE s.groupname = :groupname"),
    @NamedQuery(name = "Shoppinglist.findByListitems", query = "SELECT s FROM Shoppinglist s WHERE s.listitems = :listitems")})
public class Shoppinglist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "GROUPNAME")
    private String groupname;
    @Size(max = 200)
    @Column(name = "LISTITEMS")
    private String listitems;

    public Shoppinglist() {
    }

    public Shoppinglist(Integer id) {
        this.id = id;
    }

    public Shoppinglist(Integer id, String groupname) {
        this.id = id;
        this.groupname = groupname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getListitems() {
        return listitems;
    }

    public void setListitems(String listitems) {
        this.listitems = listitems;
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
        if (!(object instanceof Shoppinglist)) {
            return false;
        }
        Shoppinglist other = (Shoppinglist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Shoppinglist[ id=" + id + " ]";
    }
    
}
