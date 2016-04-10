/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.phillm.jc2.commands;

import net.phillm.jc2.JC2Command;

/**
 *
 * @author Phillip
 */
public class helpCmd extends JC2Command {

    final static String shortDescr = "Displays descriptions of available commands";

    public helpCmd() {
        super(shortDescr, "");

    }

    @Override
    public Boolean execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
