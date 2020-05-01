package com.anjelikabog.db.unmarshall_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hobby")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hobby {
    @XmlElement(name = "complexity")
    private Integer complexity;
    @XmlElement(name = "hobby_name")
    private String hobby_name;

    public String getHobbyName() {
        return hobby_name;
    }

    public void setHobbyName(String hobby_name) {
        this.hobby_name = hobby_name;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }
}
