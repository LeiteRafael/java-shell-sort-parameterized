package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileManager {

    public List<ArrayList<Integer>> listOfRows = new ArrayList<ArrayList<Integer>>();

    public List<ArrayList<Integer>> getListOfRows() {
        return listOfRows;
    }

    public void readFileOf(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String row = "";
        while (true) {
            if (row != null) {
                rowToList(row);
            } else
                break;
            row = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public void writeStringInFile(String path, String row) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        bufferedWriter.append(row);
        bufferedWriter.close();
    }

    private void rowToList(String row) {
        String[] listOfNumbers = row.split(" ");
        var list = new ArrayList<Integer>();
        if (!row.isBlank() && !row.equals("")) {
            for (String value : listOfNumbers) list.add(Integer.valueOf(value));
            listOfRows.add(list);
        }
    }

}