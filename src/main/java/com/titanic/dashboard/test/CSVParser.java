package com.titanic.dashboard.test;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVParser {

    public static void main(String[] args) throws Exception {

        String csvname = "train.csv";

        ClassLoader classLoader = new CSVParser().getClass().getClassLoader();

        FileReader file = new FileReader(classLoader.getResource(csvname).getFile());

        CSVReader reader = new CSVReader(file);


        List<String[]> list = reader.readAll();


    }

}
