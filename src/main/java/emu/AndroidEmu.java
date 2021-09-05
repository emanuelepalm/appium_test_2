package emu;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class AndroidEmu {
    private static String sdkPath = "C:" + File.separator + "ADB" + File.separator;
    private static String adbPath = sdkPath + "platform-tools" + File.separator + "adb";
    private static String emulatorPath = sdkPath +  "emulator" + File.separator + "emulator ";

    /**
     * Starts an emulator
     *
     *
     */
    public static void launchEmulator() {
        System.out.println("Starting emulator...");
        String[] aCommand = new String[] { "android-emulator"};
        try {
                Process process = new ProcessBuilder(aCommand).start();
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                BufferedReader br1 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line1 = null;
                while ((line1 = br1.readLine()) != null) {
                    System.out.println(line);
                }
                process.waitFor(60, TimeUnit.SECONDS);
                System.out.println("Waiting");
                Thread.sleep(5000);


            System.out.println("Emulator launched successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkDevices() {
        System.out.println("ADB DEVICES");
        String[] aCommand = new String[]{"adb","devices"};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            BufferedReader br1 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line1 = null;
            while ((line1 = br1.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeEmu() {
        System.out.println("Killing emulator session");
        String[] aCommand = new String[]{"adb","emu","kill"};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            BufferedReader br1 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line1 = null;
            while ((line1 = br1.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor(60, TimeUnit.SECONDS);
            System.out.println("Waiting");
            Thread.sleep(5000);


            System.out.println("Session Successfully killed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
