package com.pubfactory.test;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.*;


// The solution setup is where you can provide the candidate with the basic framework for their solution.
public class CsvParser {
    /**
     * Creates the parser with the CSV file to parse.
     *
     * @param file the CSV file to parse
     */
    Map<String, List> csvMatrix = new HashMap<String, List>();

    public CsvParser(String file) {
        super();

        List<String> lines = Arrays.asList(file.split("\n"));
        List<String> headers = Arrays.asList(lines.get(0).split(","));
        List<String> linesParse = new ArrayList<>();
        List<String> aux = new ArrayList<>();

        int j = 0;
        int k = 0;


        for (String line : lines) {
            if (line.contains(lines.get(0))) {
                continue;
            }
            if (j == 0) {
                for (String i : headers) {
                    linesParse = Arrays.asList(line.split(","));

                    aux = new ArrayList<>(Arrays.asList(linesParse.get(k)));
                    csvMatrix.put(i, aux);
                    k++;

                }
                j++;
                k = 0;
                continue;
            }

            linesParse = Arrays.asList(line.split(","));

            for (String i : headers) {
                if (k < headers.size()) {
                    List<String> aux1 = csvMatrix.get(i);
                    aux1.add(linesParse.get(k));
                    csvMatrix.put(i, aux1);
                    k++;


                }

            }
            k = 0;

        }

        System.out.println(csvMatrix);
    }

    /**
     * Returns the value of a specific cell.
     * <p>
     * DO NOT CHANGE THIS METHOD SIGNATURE
     *
     * @param columnName the exact name of the column
     * @param rowIndex   the 0-based index of the row not including the column header row
     * @return the cell value
     * @throws IllegalArgumentException  if columnName does not match a column
     * @throws IndexOutOfBoundsException if rowIndex < 0 or > # of rows - 1
     */
    public String getCellValue(String columnName, int rowIndex) throws Exception { // was IOException
        if (rowIndex == 0) {
            rowIndex = 1;
        }
        if(rowIndex < 0){
            throw new IllegalArgumentException();
        }
        if (csvMatrix.containsKey(columnName)) {
            List<String> column = csvMatrix.get(columnName);
            if (rowIndex > column.size() - 1) {
                throw new IndexOutOfBoundsException();
            } else {
                return column.get(rowIndex - 1);
            }

        } else {
            throw new IllegalArgumentException();
        }


    }


}