package org.example;

import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        try {
            Log my_log = new Log("log.txt");
            my_log.logger.setLevel(Level.WARNING);
            my_log.logger.info("Info msg");
            my_log.logger.warning("warning msg");
            my_log.logger.severe("Severe msg");
        } catch (Exception e) {

        }
    }
}