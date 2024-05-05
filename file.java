import java.io.*;

public class file{
    public static void main(String[] args) {
        String fileName = "example.txt";
        createFile(fileName);
        addContentToFile(fileName, "content added \n");
        System.out.println(" ");
        displayFileContent(fileName);
        deleteFileContent(fileName);
        System.out.println(" ");
        displayFileContent(fileName);
    }

    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println(" error!!");
            e.printStackTrace();
        }
    }

    public static void addContentToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            System.out.println("Content added: " + fileName);
        } catch (IOException e) {
            System.out.println("error!!.");
            e.printStackTrace();
        }
    }

    public static void displayFileContent(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(" error !!.");
            e.printStackTrace();
        }
    }

    public static void deleteFileContent(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("");
            System.out.println("Content deleted  " + fileName);
        } catch (IOException e) {
            System.out.println(" error!!");
            e.printStackTrace();
        }
    }
}

