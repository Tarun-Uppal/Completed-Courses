public class MegaBytestoKiloBytes {

    public static void main(String[] args) {

    }

    static String printMegaBytestoKiloBytes(int kiloBytes) {
        int MegaBytes = kiloBytes / 1024;
        int remainingKiloBytes = kiloBytes % 1024;
        System.out.println(kiloBytes + " KB = "
                + MegaBytes + "MB and "
                + remainingKiloBytes + "KB");

        return null;
    }
}
