package com.anjelikabog.db.unmarshall_xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "hobbies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hobbies {
    @XmlElement(name = "hobby")
    private List<Hobby> hobby=new ArrayList<Hobby>();

    public List<Hobby> getHobby() {
        return hobby;
    }


    public void setHobby(List<Hobby> hobby) {

        this.hobby = hobby;
    }
}
