package com.phonebook.models;

public class Contact {

  private String name;
  private String lastname;
  private String phone;
  private String mail;
  private String address;
  private String description;


  public Contact setName(String name) {
    this.name = name;
    return this;
  }

  public Contact setLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public Contact setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public Contact setMail(String mail) {
    this.mail = mail;
    return this;
  }

  public Contact setAddress(String address) {
    this.address = address;
    return this;

  }

  public Contact setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getPhone() {
    return phone;
  }

  public String getMail() {
    return mail;
  }

  public String getAddress() {
    return address;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "Contact{" +
        "name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        '}';
  }
}
