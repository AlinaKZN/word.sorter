package parser;

import java.util.*;

/**
 * Структура данных для хранения словаря.
 * Ключ - буква, значение - список слов.
 */
public class ParserTreeMap extends TreeMap<Character, List<String>> {

    @Override
    public String toString() {
        Iterator<Map.Entry<Character, List<String>>> i = this.entrySet().iterator();
        if (!i.hasNext()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            //начинаем вывод с символа '['
            sb.append('[');

            while(true) {
                Map.Entry<Character, List<String>> e = i.next();
                Character key = e.getKey();
                List value = e.getValue();
                //в вывод дбавляем только группы, в котрых больше 1 элемента
                if (value.size() > 1) {
                    // каждую группу разделаем запятой
                    if(sb.length() > 1) {
                        sb.append(',').append(' ');
                    }
                    //сортируем по длине, если длина равна, сортируем по алфавиту без учета регистра
                    value.sort(Comparator.comparingInt(String::length).reversed()
                            .thenComparing(String.CASE_INSENSITIVE_ORDER));
                    //добавляем запись : буква=[список слов]
                    sb.append(key);
                    sb.append('=');
                    sb.append(value);
                }
                //завершаем вывод символом ']'
                    if (!i.hasNext()) {
                        return sb.append(']').toString();
                    }
                }
        }
    }

    /**
     * Добавляет слово в словарь.
     *
     * @param aWord слово
     */
    public void add(String aWord){
        if (aWord.isEmpty()){
            return;
        }
        char firstLetter = aWord.toLowerCase().charAt(0);
        if (!containsKey(firstLetter)){
            put(firstLetter, new ArrayList<>());
        }
        get(firstLetter).add(aWord);
    }

}
