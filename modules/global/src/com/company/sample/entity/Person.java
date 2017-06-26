package com.company.sample.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "SAMPLE_PERSON")
@Entity(name = "sample$Person")
public class Person extends StandardEntity {
    private static final long serialVersionUID = 8270616036091958575L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "PHONE")
    protected String phone;

    @Column(name = "SENDING_MESSAGES", nullable = false)
    protected Boolean sendingMessages = false;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setSendingMessages(Boolean sendingMessages) {
        this.sendingMessages = sendingMessages;
    }

    public Boolean getSendingMessages() {
        return sendingMessages;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}