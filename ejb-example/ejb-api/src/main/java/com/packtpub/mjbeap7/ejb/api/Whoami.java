package com.packtpub.mjbeap7.ejb.api;

/**
 * Created by foogaro on 07/02/16.
 */
public interface Whoami {

    public final static String EJB_LOOKUP_NAME = "pippo";

    public String answer();
    public int getInvocations();

}
