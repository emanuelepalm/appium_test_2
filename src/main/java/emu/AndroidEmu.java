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
     * Starts an emulator for the provided AVD name
     *
     * @param nameOfAVD
     */
    public static void launchEmulator(String nameOfAVD) {
        System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
        String[] aCommand = new String[] { emulatorPath, "-avd", nameOfAVD,"-no-boot-anim","-wipe-data"};
        try {
            for(int i = 0; i < 10; i++) {
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
                Thread.sleep(5000);
                System.out.println("Waiting");
                Thread.sleep(5000);
                System.out.println("Waiting");
                Thread.sleep(5000);
                System.out.println("Waiting");
            }
            System.out.println("Emulator launched successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
