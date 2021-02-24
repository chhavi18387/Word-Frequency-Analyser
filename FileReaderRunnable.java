package codingmafia.project1;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReaderRunnable implements Runnable {
    private Map<String, Integer> wordMap = new HashMap<String, Integer>();
    private String filePath;

    public FileReaderRunnable(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        // what will happen in this thread - we need to write it here

        // read file and append to map
        File file = new File(this.filePath);
        try {
            //reading file and creating a map
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                //reading a line
                String data = reader.nextLine();
                String[] words = data.split(" ");
                // adding all the words in a line to map
                for (String w : words) {
                    w = w.toLowerCase();
                    Integer count = wordMap.containsKey(w) ? wordMap.get(w) : 0;
                    wordMap.put(w, count + 1);
                }
            }
            // hashmap completed
            // closing file
            reader.close();

            //calling HashMapSorter
            WordSetSorter h = new WordSetSorter();
            h.sortMap(wordMap, true);
            h.printMap(h.sortMap(wordMap, false));


        } catch (FileNotFoundException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

}
