package com.packtpub.mjbeap7.ejb;

import com.packtpub.mjbeap7.ejb.api.Stats;
import com.packtpub.mjbeap7.ejb.api.Whoami;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Created by foogaro on 07/02/16.
 */
@Stateful
@Remote({Whoami.class, Stats.class})
public class WhoamiBean implements Whoami, Stats {

    private int invocations = 0;

    @Override
    public String answer() {
        ++invocations;
        System.out.println("Whoami[" + invocations + "]");
        return "Foogaro";
    }

    @Override
    public int getInvocations() { return invocations; }

    @Override
    public int get() {
        return invocations;
    }
}
