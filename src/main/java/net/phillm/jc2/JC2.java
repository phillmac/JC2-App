/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.phillm.jc2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
            currentCommand = scanner.nextLine().toLowerCase();

            if (currentCommand.contains("/info")) {
                System.out.println("Build Version: " + version);
                System.out.println("Website: " + website);
                System.out.println("View on Github: " + github);

            } else if (currentCommand.contains("/website") || currentCommand.contains("/site")) {
                System.out.println("Website: " + website);

            } else if (currentCommand.contains("/help")) {
                System.out.println("/Info: Gives Info Such as Build Version, Website, and Github Link");
                System.out.println("/Website: Gives The Developers Website");
                System.out.println("/Help: Lists Available Commands");
                System.out.println("/Stop | /quit | /exit | /close: Close the console");

            } else if (currentCommand.contains("/stop") || currentCommand.contains("/quit") || currentCommand.contains("/exit") || currentCommand.contains("/close")) {
                System.out.println("Stopping");
                runLoop = false;
            } else if (currentCommand.contains("/plugins") || currentCommand.contains("/pl")) {
                List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
                
                System.out.println("Available Plugins: "+pluginManager.getExtensionClassNames(null).toString());
                
                for (PluginWrapper plugin : startedPlugins) {
                    String pluginId = plugin.getDescriptor().getPluginId();
                    System.out.println(String.format("Extensions added by plugin '%s':", pluginId));
                    for (String extension : pluginManager.getExtensionClassNames(pluginId)) {
                        System.out.println("   " + extension);
                    }
                }

            }

        }
    }
}
