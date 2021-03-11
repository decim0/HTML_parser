package org.example;

import org.jsoup.nodes.Document;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToArray {

    private static final Logger logger = Logger.getLogger(ToArray.class.getName());

    public String[] textToArray(Document document) {

        if (document == null) {
            logger.info("Не удалось получить URL!");
            return null;
        }

        String text = document.body().text().trim().toUpperCase();
        Pattern pattern = Pattern.compile("(\\W)|(\\d)", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(" ");
        return text.split("\\s+");
    }
}
