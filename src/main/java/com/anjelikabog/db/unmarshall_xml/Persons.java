package com.anjelikabog.db.unmarshall_xml;


import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Persons")
@XmlAccessorType(XmlAccessType.FIELD)
public class Persons{
    @XmlElement(name = "Person")
    private List<Person> persons=new ArrayList<Person>();

    public List<Person> getPersons() {
        return persons;
    }


    public void setPersons(List<Person> persons) {

        this.persons = persons;
    }
}

