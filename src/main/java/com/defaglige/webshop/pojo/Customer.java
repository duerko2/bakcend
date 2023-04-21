package com.defaglige.webshop.pojo;

public class Customer {
    private String name;

    private String phone;

    private String email;

    private String address;

    private String zip;

    private String city;

    private String password;


    private String country;

    private String company;

    private String vat;

    public Customer(String name, String phone, String email, String address, String zip, String city, String country, String password, String company, String vat) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.password = password;
        this.company = company;
        this.vat = vat;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany() {
        return company;
    }

    public String getVat() {
        return vat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPassword(String code) {
        this.password = code;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }
}
