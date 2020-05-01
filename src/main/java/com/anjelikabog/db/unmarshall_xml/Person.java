package com.anjelikabog.db.unmarshall_xml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "birthday")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date birthday;
    @XmlElement(name = "hobbies")
    private List<Hobbies> hobbies= new ArrayList<Hobbies>();

    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }

    public Date getBirthday() {

        return birthday;
    }


    public void setBirthday(Date birthday) {

        this.birthday = birthday;
    }

    public List<Hobbies> getHobbies() {
        return hobbies;
    }


    public void setHobbies(List<Hobbies> hobbies){
        this.hobbies = hobbies;
    }
}
