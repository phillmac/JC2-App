/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.phillm.jc2;

import java.util.ArrayList;

/**
 *
 * @author Phillip
 */
abstract public class JC2Command {

    final String shortDescription;
    final String longDescription;
    final ArrayList<String> Aliases = new ArrayList<>();

    public JC2Command(String shortDescr, String longDescr) {
        shortDescription = shortDescr;
        longDescription = longDescr;
    }

    public String getShortDescr() {
        return shortDescription;

    }

    public String getLongDescr() {
        return longDescription;

    }

    public ArrayList<String> getAliases() {
        return Aliases;

    }

    public abstract Boolean execute();
}
