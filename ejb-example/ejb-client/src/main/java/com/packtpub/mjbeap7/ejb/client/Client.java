package com.packtpub.mjbeap7.ejb.client;

import com.packtpub.mjbeap7.ejb.api.Stats;
import com.packtpub.mjbeap7.ejb.api.Whoami;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by foogaro on 08/02/16.
 */
public class Client {

    private final static String appName = "ear";
    private final static String moduleName = "ejb";
    private final static String distinctName = "";
    private final static String beanName = "WhoamiBean";
    private final static String providerUrl = "remote://192.168.59.103:8180";

    public static void main(String[] args) {
        //final Hashtable jndiProperties = new Hashtable();
        //jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        //Context context = new InitialContext(jndiProperties);
        //context.lookup("ejb:TestTimer/TestTimerEJB/TimerExampleBean!org.example.jboss.timer.TimerExample");
        Whoami whoami = getWhoami();
        System.out.println("Whoami => " + whoami);
//        String answer = whoami.answer();
        System.out.println("answer 1=> " + whoami.answer());
        System.out.println("answer 2=> " + whoami.answer());
        System.out.println("answer 3=> " + whoami.answer());
        System.out.println("answer 4=> " + whoami.answer());
        System.out.println("answer 5=> " + whoami.answer());
        System.out.println("answer => " + whoami.getInvocations());

        Stats stats = getStats();
        System.out.println("Stats => " + stats);
//        answer = stats.get()+"";
        System.out.println("stats 1=> " + stats.get());
        System.out.println("stats 2=> " + stats.get());
        System.out.println("stats 3=> " + stats.get());
        System.out.println("stats 4=> " + stats.get());
        System.out.println("stats 5=> " + stats.get());
    }

    private static Whoami getWhoami() {
        try {
            // the remote view fully qualified class name
            final String viewClassName = Whoami.class.getName();
            //return getWhoami("ejb:ear-with-ejb/remote-ejb-server/WhoamiBean!com.packtpub.mjbeap7.ejb.api.Whoami?stateful");
            System.out.println("CALLING --> " + "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
            return getWhoami("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }

        throw new RuntimeException("Unable to lookup Whoami EJB");
    }

    private static Whoami getWhoami(String jndi) throws NamingException {
        final Hashtable jndiProperties = new Hashtable();

        String JBOSS_CONTEXT = "org.jboss.naming.remote.client.InitialContextFactory";
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, JBOSS_CONTEXT);
        jndiProperties.put(Context.PROVIDER_URL, providerUrl);
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb.2015");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = new InitialContext(jndiProperties);
        return (Whoami) context.lookup(jndi);
    }

    private static Stats getStats() {
        try {
            // the remote view fully qualified class name
            final String viewClassName = Stats.class.getName();
            //return getWhoami("ejb:ear-with-ejb/remote-ejb-server/WhoamiBean!com.packtpub.mjbeap7.ejb.api.Whoami?stateful");
            System.out.println("CALLING --> " + "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
            return getStats("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }

        throw new RuntimeException("Unable to lookup Stats EJB");
    }

    private static Stats getStats(String jndi) throws NamingException {
        final Hashtable jndiProperties = new Hashtable();

        String JBOSS_CONTEXT = "org.jboss.naming.remote.client.InitialContextFactory";
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, JBOSS_CONTEXT);
        jndiProperties.put(Context.PROVIDER_URL, providerUrl);
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb.2015");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = new InitialContext(jndiProperties);
        return (Stats) context.lookup(jndi);
    }

}
