package emu;

import java.io.File;
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
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(60, TimeUnit.SECONDS);
            System.out.println("Emulator launched successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
