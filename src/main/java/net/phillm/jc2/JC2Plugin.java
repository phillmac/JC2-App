/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.phillm.jc2;

import ro.fortsoft.pf4j.Plugin;
import ro.fortsoft.pf4j.PluginWrapper;

/**
 *
 * @author Phillip
 */
public abstract class JC2Plugin extends Plugin implements API.PluginAPI{

    public JC2Plugin(PluginWrapper wrapper) {
        super(wrapper);
    }
    abstract public boolean extractConfig() ;
}
