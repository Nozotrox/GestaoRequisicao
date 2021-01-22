package com.example.accessingdatamysql.responseRequestBodies;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
    public String contacto;
    public String password;

    public Login(@JsonProperty("contacto") String contacto,
                 @JsonProperty("password") String password) {
        this.contacto = contacto;
        this.password = password;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
