package moz.io;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by mozEvil on 06.11.2016.
 */
public class FileWork {

    private File file;

    public FileWork(String path) {
        file = new File(path);
    }

    public FileWork(File file) {
        this.file = file;
    }

    public ArrayList<String> read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> list = new ArrayList<>();
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
            return list;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void write(ArrayList<String> list) {
        try {
            FileWriter writer = new FileWriter(file, false);

            for (String s : list) {
                writer.write(s + "\n");
            }
            writer.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
