package eu.axasoft.soapsettest.core;

import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author kralmatej
 */
@Named(value = "applicationBean")
@ApplicationScoped
public class ApplicationBean {

    private String test = "Lalala";
    
    public ApplicationBean() {
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
}
