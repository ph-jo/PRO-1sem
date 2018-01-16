import java.io.File;

public class FilePathing {

    public static void scanDir(String path) {
        System.out.println("[DIR] " + path);

        File file = new File(path);
        String[] names = file.list();

        for (String name : names) {
            String newPath = path + "\\" + name;
            if ((new File(newPath)).isDirectory()) {
                scanDir(newPath);
            }
        }
    }

    public static int scanDirCount(String path) {
        int count = 0;
        File file = new File(path);
        String[] names = file.list();

        for (String name : names) {
            String newPath = path + "\\" + name;
            if ((new File(newPath).isDirectory())) {
                count++;
                scanDirCount(newPath);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        scanDir("C:\\Users\\Jonat\\Pictures");
        System.out.println(scanDirCount("C:\\Users\\Jonat\\Pictures"));
    }
}