package com.mislbd.ababil.integration.test.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Data {

    @Id
    @GeneratedValue
    private Long id;
    private String contentValue;
    private String jsonBody;

    public Data(){

    }

    public Data(Long id, String contentValue, String jsonBody) {
        this.id = id;
        this.contentValue = contentValue;
        this.jsonBody = jsonBody;
    }

    public Data(String contentValue, String jsonBody){
        this.contentValue = contentValue;
        this.jsonBody = jsonBody;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

    public String getJsonBody() {
        return jsonBody;
    }

    public void setJsonBody(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    @Override
    public String toString(){
        return  "\n" + "Data {" + "id=" + id + ", content=" + contentValue + ", json=" + jsonBody + '}' ;
    }
}
