package com.leniot.management.track.utils;
/*
 * Copyright PT LEN INNOVATION TECHNOLOGY
 *
 * THIS SOFTWARE SOURCE CODE AND ANY EXECUTABLE DERIVED THEREOF ARE PROPRIETARY
 * TO PT LEN INNOVATION TECHNOLOGY, AS APPLICABLE, AND SHALL NOT BE USED IN ANY WAY
 * OTHER THAN BEFOREHAND AGREED ON BY PT LEN INNOVATION TECHNOLOGY, NOR BE REPRODUCED
 * OR DISCLOSED TO THIRD PARTIES WITHOUT PRIOR WRITTEN AUTHORIZATION BY
 * PT LEN INNOVATION TECHNOLOGY, AS APPLICABLE.
 */

/*
 * @author Hendra
 * */

/*
 * the class for load env file
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnvLoader {
    /* Load env config.env
     */
    private static final LoggingImpl logging = LoggingImpl.getInstance(
            new Object() { }.getClass().getEnclosingClass());
    public static Map<String, String> loadEnvVariables() {
        String currentDir = System.getProperty("user.dir");
        String filename = currentDir + "/config.env"; //For Docker & Run in Jar


        Map<String, String> envVariables = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    envVariables.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            logging.error(String.valueOf(e),"Can't Load Config.env file, config.env is missing");
            e.printStackTrace();
        }
        return envVariables;
    }
}
