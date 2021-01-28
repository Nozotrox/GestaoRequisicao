package com.example.accessingdatamysql.responseRequestBodies;

public class Contact {
    private String contacto;

    public Contact() {

    }

    public Contact(String contacto) {
        this.contacto = contacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
