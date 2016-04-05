/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.phillm.jc2;

import java.util.ArrayList;
import ro.fortsoft.pf4j.ExtensionPoint;

/**
 *
 * @author Phillip
 */
abstract public class API {
    public interface CommandAPI extends ExtensionPoint {
    public ArrayList<JC2Command> getPluginCommands();
          
    }
        public interface PluginAPI extends ExtensionPoint {
    public String getVersion();
        
        
    }
}
