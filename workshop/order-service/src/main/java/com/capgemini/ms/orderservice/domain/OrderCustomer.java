package com.capgemini.ms.orderservice.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderCustomer implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;
  @Version
  @Column(name = "version")
  private int version;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof OrderCustomer)) {
      return false;
    }
    OrderCustomer other = (OrderCustomer) obj;
    if (id != null) {
      if (!id.equals(other.id)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
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

  @Override
  public String toString() {
    String result = getClass().getSimpleName() + " ";
    if (name != null && !name.trim().isEmpty())
      result += "name: " + name;
    if (email != null && !email.trim().isEmpty())
      result += ", email: " + email;
    return result;
  }
}