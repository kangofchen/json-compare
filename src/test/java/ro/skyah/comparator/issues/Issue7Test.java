package ro.skyah.comparator.issues;

import org.junit.Test;
import ro.skyah.comparator.JSONCompare;

public class Issue7Test {

    @Test
    public void matchUseCaseLiterals() {
        String expected = "{\"records\": [\".*\"]}";
        String actual = "{\"records\": [\".*\" ]}";
        JSONCompare.assertEquals(expected, actual);
        expected = "{\"records\": [\"\\\\!.*\"]}";
        actual = "{\"records\": [\"!.*\" ]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test(expected = AssertionError.class)
    public void matchUseCaseLiterals_negative() {
        String expected = "{\"records\": [\"!.*\"]}";
        String actual = "{\"records\": [\"!.*\" ]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoExtraElements() {
        String expected = "{\"records\": [\"!.*\"]}";
        String actual = "{\"records\": []}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoExtraElements1() {
        String expected = "{\"records\": [\"!.*\"]}";
        String actual = "{\"records\": [{\"a\":0}]}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasExtraElements() {
        String expected = "{\"records\": [\".*\"]}";
        String actual = "{\"records\": [1,2]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasExtraElements1() {
        String expected = "{\"records\": [\".*\"]}";
        String actual = "{\"records\": [{\"a\":0}]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasExtraElements2() {
        String expected =
                "{\"records\":[\".*\"]}";
        String actual = "{\"records\":[{\"a\":0}]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasExtraElements3() {
        String expected =
                "{\"records\":[\".+\"]}";
        String actual = "{\"records\":[false]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasExtraElements4() {
        String expected = "{\"records\": [[1], false, \".*\"]}";
        String actual = "{\"records\": [[1], {\"a\":0}, false]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasExtraElements4_negative() {
        String expected = "{\"records\": [{\"a\":0}, [1], false, \".+\"]}";
        String actual = "{\"records\": [[1], {\"a\":0}, false]}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoExtraElements3_negative() {
        String expected =
                "{\"records\":[\".+\"]}";
        String actual = "{\"records\":[]}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoTextElementThatMatchesTheExpectedTextValue() {
        String expected = "{\"records\": [\"!b\"]}";
        String actual = "{\"records\": [\"c\"]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test(expected = AssertionError.class)
    public void checkJsonArrayHasNoTextElementThatMatchesTheExpectedTextValue_negative() {
        String expected = "{\"records\": [\"!b\"]}";
        String actual = "{\"records\": [\"b\"]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasJsonObjectElementThatMatchesTheExpectedTextValue() {
        String expected = "{\"records\": [{\".*\": \".*\"}]}";
        String actual = "{\"records\": [{\"a\": 0}]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test(expected = AssertionError.class)
    public void checkJsonArrayHasNoJsonObjectElementThatMatchesTheExpectedTextValue_negative1() {
        String expected = "{\"records\": [{\"!.*\": \".*\"}]}";
        String actual = "{\"records\": [\"a\", [true]]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasAJsonObjectElementThatMatchesTheExpectedJsonObjectValue() {
        String expected = "{\"records\": [{\"!.*\": \".*\"}]}";
        String actual = "{\"records\": [{\"a\":0}]}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasAJsonObjectElementThatMatchesTheExpectedJsonObjectValue1() {
        String expected = "{\"records\": [{\"!.*\": \".*\"}]}";
        String actual = "{\"records\": [\"test\"]}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoJsonObjectElementThatMatchesTheExpectedTextValue3() {
        String expected = "{\"records\": [{\"a\": \"!b\"}]}";
        String actual = "{\"records\": [{\"a\": \"c\"}]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoJsonObjectElementThatMatchesTheExpectedTextValue4() {
        String expected = "{\"records\": [{\"a\": \"!b\"}]}";
        String actual = "{\"records\": [{\"b\": \"c\"}]}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoJsonObjectElementThatMatchesTheExpectedTextValue5() {
        String expected = "{\"records\": [{\"!a\": \"b\"}]}";
        String actual = "{\"records\": [{\"x\": \"b\"}]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoJsonObjectElementThatMatchesTheExpectedTextValue6() {
        String expected = "{\"records\": [{\"!a\": \"b\"}]}";
        String actual = "{\"records\": [{\"x\": \"c\"}]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonObjectDoNotFindKeyHasValueMatch() {
        String expected = "{\"!a\": \"b\"}";
        String actual = "{\"x\": \"b\"}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonObjectDoNotFindKeyHasValueMatch1() {
        String expected = "{\"!a\": \"b\"}";
        String actual = "{\"x\": \"c\"}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test(expected = AssertionError.class)
    public void checkJsonArrayHasNoJsonObjectElementThatMatchesTheExpectedTextValue3_negative() {
        String expected = "{\"records\": [{\"a\": \"!b\"}]}";
        String actual = "{\"records\": [{\"a\": \"b\"}]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoTextElementThatMatchesTheExpectedTextValue1() {
        String expected = "{\"records\": [\"!b\"]}";
        String actual = "{\"records\": [{\"a\": 0}, \"c\"]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test(expected = AssertionError.class)
    public void checkJsonArrayHasNoJsonObjectElementThatMatchesTheExpectedTextValue_negative() {
        String expected = "{\"records\": [\"!b\"]}";
        String actual = "{\"records\": [{\"a\": 0}, \"b\"]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoElementThatMatchesTheExpectedJsonObject1() {
        String expected = "{\"records\": [ {\"!a\": 0} ]}";
        String actual = "{\"records\": [ \"b\" ]}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test(expected = AssertionError.class)
    public void checkJsonArrayHasNoElementThatMatchesTheExpectedJsonObject_negative() {
        String expected = "{\"records\": [ {\"!a\": 0} ]}";
        String actual = "{\"records\": [ \"b\", {\"a\": 0} ]}";
        JSONCompare.assertEquals(expected, actual);
    }


    @Test
    public void checkJsonArrayHasNoElementThatMatchesTheExpectedJsonArray() {
        String expected = "{\"records\": [ [\"!a\"] ]}";
        String actual = "{\"records\": [ \"b\" ]}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoJsonArrayElementThatMatchesTheExpectedTextValue() {
        String expected = "{\"records\": [ [\"!c\"] ]}";
        String actual = "{\"records\": [ [\"b\"] ]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test(expected = AssertionError.class)
    public void checkJsonArrayHasNoJsonArrayElementThatMatchesTheExpectedTextValue_negative() {
        String expected = "{\"records\": [\"!t.*\"]}";
        String actual = "{\"records\": [ [\"b\"], true ]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoElementThatMatchesTheExpectedJsonObjectValue() {
        String expected = "{\"records\": [ {\"!b\":\"0\"} ]}";
        String actual = "{\"records\": [{\"a\":\"0\"}]}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void checkJsonArrayHasNoJsonObjectElementThatMatchesTheExpectedJsonObjectValue_negative() {
        String expected = "{\"records\": [ {\"!b\":\"0\"} ]}";
        String actual = "{\"records\": [{\"a\":\"0\"}, [true], {\"b\":\"0\"} ]}";
        JSONCompare.assertEquals(expected, actual);
    }
}
