package com.catalyst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name = "guest_roster")
@NamedQueries({@NamedQuery(name = "getAllGuests", query = "SELECT g FROM Guest g"),
@NamedQuery(name = "getGuestById", query = "SELECT g FROM Guest g WHERE g.id = :id"),
@NamedQuery(name = "deleteGuestById", query = "DELETE FROM Guest g WHERE g.id = :id"),


})
public class Guest {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @Column(name = "guest_name")
  private String name;
  @Column(name = "guest_email")
  private String email; 
  @Column(name = "guest_address")
  private String address;
  @Column(name = "guest_quantity")
  private String qty;
  
  private Integer version;
  
  @Version
  @Column(name="VERSION")
  public Integer getVersion() {

		return version;
	}

  public void setVersion(Integer version){ this.version = version;}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    StringBuffer strBuff = new StringBuffer();
    strBuff.append("id : ").append(id);
    strBuff.append(", name : ").append(name);
    strBuff.append(",email : ").append(email);
    strBuff.append(",address : ").append(address);
    strBuff.append(",qty : ").append(qty);
    return strBuff.toString();
  }

  public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }

}
