package com.packtpub.mjbeap7.rs;

import com.packtpub.mjbeap7.ejb.api.Stats;
import com.packtpub.mjbeap7.ejb.api.Whoami;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by foogaro on 07/02/16.
 */
@Stateless
public class Service {

    private final String appName = "ear";
    private final String moduleName = "ejb";
    private final String distinctName = "";
    private final String beanName = "WhoamiBean";

    @EJB(lookup = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!com.packtpub.mjbeap7.ejb.client.Whoami?stateful")
    private Whoami whoami;

    @EJB(lookup = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!com.packtpub.mjbeap7.ejb.client.Stats?stateful")
    private Stats stats;

    public String whoamiLocally() {
        return "Luigi";
    }

    public String whoamiRemotely() {
//        Whoami whoami = getWhoami();
        System.out.println("===> whoami: " + whoami);
        return whoami.answer();
    }

    public int stats() {
//        Stats stats = getStats();
        System.out.println("===> stats: " + stats);
        return stats.get();
    }

    private Whoami getWhoami() {
        try {
            final String viewClassName = Whoami.class.getName();
            return getWhoami("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }

        throw new RuntimeException("Unable to lookup Whoami EJB");
    }

    private Whoami getWhoami(String jndi) throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = new InitialContext(jndiProperties);
        return (Whoami) context.lookup(jndi);
    }

    private Stats getStats() {
        try {
            final String viewClassName = Stats.class.getName();
            return getStats("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }

        throw new RuntimeException("Unable to lookup Stats EJB");
    }

    private Stats getStats(String jndi) throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = new InitialContext(jndiProperties);
        return (Stats) context.lookup(jndi);
    }

}
