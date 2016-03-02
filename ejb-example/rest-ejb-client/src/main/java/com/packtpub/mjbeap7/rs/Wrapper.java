package com.packtpub.mjbeap7.rs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by foogaro on 07/02/16.
 */
@XmlRootElement
public class Wrapper implements Serializable{

    private String result;

    public Wrapper() {
    }

    public Wrapper(String result) {
        this.result = result;
    }

    public Wrapper(Integer result) {
        this.result = result.intValue() + "";
    }

    @XmlElement
    public String getResult() {
        return result;
    }
}
