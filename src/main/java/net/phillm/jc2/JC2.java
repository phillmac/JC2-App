/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.phillm.jc2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import ro.fortsoft.pf4j.DefaultPluginManager;
import ro.fortsoft.pf4j.PluginManager;
import ro.fortsoft.pf4j.PluginWrapper;

/**
 *
 * @author Phillip
 * @author Ethan
 */
public class JC2 {

    // Specifies Version
    final static String version = "1.0.0 - SNAPSHOT";
    // Specifies Website
    final static String website = "https://github.com/phillmac";
    // Specifies Github Repo
    final static String github = "https://github.com/phillmac/javaconsole";

    static List<JC2> appsList = new ArrayList();
    static PluginManager pluginManager = new DefaultPluginManager();

    public static void main(String[] args) {
        
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "WARN");

        JC2 mainApp;
        mainApp = new JC2();

        appsList.add(mainApp);
        mainApp.run();
    }

    public void run() {
        //Initialize main loop
        boolean runLoop;
        runLoop = true;
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        Scanner scanner = new Scanner(System.in);
        String currentCommand;

        System.out.println("Info: Type /info to get the build version!");
        System.out.println("Info: Type /help to get a list of availble commands!");

        while (runLoop) { //loop untill /stop command
            currentCommand = StringUtils.removeStart(scanner.nextLine().toLowerCase(),"/");

            if (currentCommand.startsWith("info")) {
                System.out.println("Build Version: " + version);
                System.out.println("Website: " + website);
                System.out.println("View on Github: " + github);

            } else if (currentCommand.startsWith("website") || currentCommand.startsWith("site")) {
                System.out.println("Website: " + website);

            } else if (currentCommand.startsWith("help")) {
                System.out.println("/Info: Gives Info Such as Build Version, Website, and Github Link");
                System.out.println("/Website: Gives The Developers Website");
                System.out.println("/Help: Lists Available Commands");
                System.out.println("/Stop | /quit | /exit | /close: Close the console");
                System.out.println("/Plugins: Lists Plugins");

            } else if (currentCommand.startsWith("stop") || currentCommand.startsWith("quit") || currentCommand.startsWith("exit") || currentCommand.startsWith("close")) {
                System.out.println("Stopping");
                pluginManager.stopPlugins();
                runLoop = false;
            } else if (currentCommand.startsWith("plugins") || currentCommand.startsWith("pl")) {
                List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
                List<PluginWrapper> availablePlugins = pluginManager.getPlugins();
                System.out.println("Available Plugins:");
                
                availablePlugins.stream().forEach((plugin) -> {
                    String pluginId = plugin.getDescriptor().getPluginId();
                    String pluginStatus = plugin.getPluginState().toString();
                    System.out.println(String.format("Name: '%s' Status: '%s'", pluginId, pluginStatus));
                }); //for (PluginWrapper plugin : startedPlugins) {
                //    String pluginId = plugin.getDescriptor().getPluginId();
                //    System.out.println(String.format("Extensions added by plugin '%s':", pluginId));
                //    for (String extension : pluginManager.getExtensionClassNames(pluginId)) {
                //        System.out.println("   " + extension);
                //   }
                //}

            }

        }
    }
}
