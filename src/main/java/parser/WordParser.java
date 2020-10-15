package parser;

import java.awt.desktop.SystemSleepEvent;
import java.util.stream.Stream;

/**
 * Парсер, который преобразует строку.
 * На вход - строка из слов, разделенных пробелом. Слова должны состоять из букв.
 * На выходе - строка в формате  [первая буква слов=[слова, отсортированные по убыванию длины, и по алфавиту для слов одной длины], ...]
 */
public class WordParser {

    public static String parse(String aStr){
        ParserTreeMap vocabulary = new ParserTreeMap();
        Stream.of(aStr.split("[^A-Za-zА-Яа-я]+")).forEach(w -> vocabulary.add(w));
        return vocabulary.toString();
    }

}
