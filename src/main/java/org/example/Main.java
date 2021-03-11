package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        if (args.length == 0) {
            logger.info("Аргумент не задан!");
            System.exit(0 );
        }

        String url = args[0];
        if (isBlank(url)) {
            logger.info("Не указан URL!");
            System.exit(0);
        }

        Document document;
        ToMap toMap;
        ToArray toArray;
        String file = "file.html";
        try (FileWriter fileWriter = new FileWriter(file)) {
            document = Jsoup.connect(url).get();
            fileWriter.write(document.toString());
            fileWriter.flush();
            document = Jsoup.parse(new File(file), "CP1251");
            toArray = new ToArray();
            String[] words = toArray.textToArray(document);
            toMap = new ToMap();
            toMap.arrayToMap(words);
        } catch (IOException e) {
            logger.info("Заданный URL не найден!");
        }
    }
}