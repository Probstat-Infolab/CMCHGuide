package com.probstatinfolab.tottho;

/**
 * Created by RONY on 26-10-16.
 */
public class Department {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private String service;
    private String position;

    public Department(String name, String service, String posotion) {
        this.name = name;
        this.service = service;
        this.position = posotion;
    }


}
