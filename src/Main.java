import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        StringBuilder log = new StringBuilder("Creating directories and files " + "\n");

        String[] directories = {"D:\\Games\\src", "D:\\Games\\src\\main",
                                "D:\\Games\\src\\test", "D:\\Games\\res",
                                "D:\\Games\\res\\drawables",
                                "D:\\Games\\res\\vectors", "D:\\Games\\res\\icons",
                                "D:\\Games\\savegames", "D:\\Games\\temp"};

        String[] files = {"D:\\Games\\src\\main\\Main.java", "D:\\Games\\src\\main\\Utils.java",
                          "D:\\Games\\temp\\temp.txt"};

        for (int i = 0; i < directories.length; i++) {
            File directory = new File(directories[i]);
            if (directory.mkdir()) {
                System.out.println(directory.getName() + "- directory was created");
            } else if (directory.exists()) {
                System.out.println(directory.getName() + "- directory already exists");
            } else System.out.println("- directory has not created");
            log.append(directory.getName() + "- was created" + "\n");
        }

        for (int i = 0; i < files.length; i++) {
            File file = new File(files[i]);
            if (file.createNewFile()) {
                System.out.println(file.getName() + "- file was created");
            } else if (file.exists()) {
                System.out.println(file.getName() + "- file already exists");
            } else System.out.println("- file has not created");
            log.append(file.getName() + "- was created" + "\n");
        }

        File newLog = new File("D:\\Games\\temp\\temp.txt");
        try (FileWriter fw = new FileWriter(newLog)) {
            fw.write(log.toString());
        } catch (IOException e) {
            e.getMessage();
        }
    }
}





//OR
/*import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        StringBuilder log = new StringBuilder("Creating directories and files " + "\n");

        String[] message = {" - directory has created", " - file has created",
                " - hasn't created", " already exists"};
        String path = "D:\\Games\\";

        String[] gamesDir = {"src", "res", "savegames", "temp"};
        String[] srcDir = {"main", "test"};
        String[] resDir = {"drawables", "vectors", "icons"};
        String[] mainFiles = {"Main.java", "Utils.java"};
        String[] tempFiles = {"temp.txt"};

        for (int i = 0; i < gamesDir.length; i++) {
            String fullPath = path + gamesDir[i];
            File directoryGames = new File(fullPath);
            if (directoryGames.mkdir()) {
                System.out.println(directoryGames.getName() + message[0]);
            } else if (directoryGames.exists()) {
                System.out.println(directoryGames.getPath() + message[3]);
            } else System.out.println(message[2]);
            log.append(directoryGames.getName() + message[0] + "\n");
        }

        for (int i = 0; i < srcDir.length; i++) {
            String fullPath = path + gamesDir[0] + "\\" + srcDir[i];
            File directoryScr = new File(fullPath);
            if (directoryScr.mkdir()) {
                System.out.println(directoryScr.getName() + message[0]);
            } else if (directoryScr.exists()) {
                System.out.println(directoryScr.getPath() + message[3]);
            } else System.out.println(message[2]);
            log.append(directoryScr.getName() + message[0] + "\n");
        }

        for (int i = 0; i < resDir.length; i++) {
            String fullPath = path + gamesDir[1] + "\\" + resDir[i];
            File directoryRes = new File(fullPath);
            if (directoryRes.mkdir()) {
                System.out.println(directoryRes.getName() + message[0]);
            } else if (directoryRes.exists()) {
                System.out.println(directoryRes.getPath() + message[3]);
            } else System.out.println(message[2]);
            log.append(directoryRes.getName() + message[0] + "\n");
        }

        for (int i = 0; i < mainFiles.length; i++) {
            String mainPath = path + gamesDir[0] + "\\" + srcDir[0] + "\\" + mainFiles[i];
            File fileInMain = new File(mainPath);
            try {
                if (fileInMain.createNewFile())
                    System.out.println(fileInMain + message[1]);
                else System.out.println(fileInMain.getPath() + message[3]);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            log.append(fileInMain.getName() + message[1] + "\n");
        }

        for (int i = 0; i < tempFiles.length; i++) {
            String mainPath = path + gamesDir[3] + "\\" + tempFiles[i];
            File fileInTemp = new File(mainPath);
            try {
                if (fileInTemp.createNewFile())
                    System.out.println(fileInTemp + message[1]);
                else System.out.println(fileInTemp.getPath() + message[3]);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            log.append(fileInTemp.getName() + message[1] + "\n");

        }

        File newLog = new File("D:\\Games\\temp\\temp.txt");
        try (FileWriter fw = new FileWriter(newLog)) {
            fw.write(log.toString());
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
*/

/* OR
// import java.io.*;

public class Main {

    static StringBuilder log = new StringBuilder("Creating directories and files " + "\n");

    static String path = "D:\\Games\\";

    public static void main(String[] args) {

        StringBuilder log = new StringBuilder("Creating directories and files " + "\n");

        String path = "D:\\Games\\";

        createDirectory("src");
        createDirectory("src/main");
        createFile("src/main/Main.java");
        createFile("src/main/Utils.java");
        createDirectory("src/test");
        createDirectory("res");
        createDirectory("res/drawables");
        createDirectory("res/vectors");
        createDirectory("res/icons");
        createDirectory("savegames");
        createDirectory("temp");
        createFile("temp/temp.txt");


        File newLog = new File("D:\\Games\\temp\\temp.txt");
        try (FileWriter fw = new FileWriter(newLog)) {
            fw.write(log.toString());
        } catch (IOException e) {
            e.getMessage();
        }

    }

    static String logResult(Boolean done, File type, String name) {
        if (type.isDirectory()) {
            return done ? "Directory " + name + " has created" : "Directory " + name + " has not created";
        } else {
            return done ? "File " + name + " has created" : "File " + name + " has not created";
        }
    }

    static void createDirectory(String name) {
        File dir = new File(path + name);
        log.append(logResult(dir.mkdir(), dir, name) + "\n");
    }

    static void createFile(String name) {
        File file = new File(path + name);
        try {
            log.append(logResult(file.createNewFile(), file, name) + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
*/
