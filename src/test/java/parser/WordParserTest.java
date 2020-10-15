package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тест
 */
class WordParserTest {
    //входная строка
    private final static String STR = "сапог сарай арбуз болт бокс биржа";
    private final static String STR0 = "сапог сарай арбуз болты бокс биржа болт Болт Сапог";
    private final static String STR1 = "as dd d aaaa aa y aaa";
    private final static String STR2 = "1111 1 111 112 2 11";


    //ожидаемая
    private static final String EXPECT_STR = "[б=[биржа, бокс, болт], с=[сапог, сарай]]";
    private static final String EXPECT_STR0 ="[б=[биржа, болты, бокс, болт, Болт], с=[сапог, Сапог, сарай]]";
    private static final String EXPECT_STR1 = "[a=[aaaa, aaa, aa, as], d=[dd, d]]";
    private static final String EXPECT_STR2 = "[]";

    @Test
    void parse() {
        assertEquals(EXPECT_STR, WordParser.parse(STR));
        assertEquals(EXPECT_STR0, WordParser.parse(STR0));
        assertEquals(EXPECT_STR1, WordParser.parse(STR1));
        assertEquals(EXPECT_STR2, WordParser.parse(STR2));
    }
}