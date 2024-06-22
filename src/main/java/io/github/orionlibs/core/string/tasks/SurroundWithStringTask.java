package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.abstraction.Orion;

public class SurroundWithStringTask extends Orion
{
    public static String run(String aString, String stringToSurroundInputWith)
    {
        return run(aString, stringToSurroundInputWith, stringToSurroundInputWith);
    }


    public static String run(String aString, String stringPrefix, String stringSuffix)
    {
        StringBuilder stringSurroundedWithSingleQuote = new StringBuilder(stringPrefix);
        stringSurroundedWithSingleQuote.append(aString);
        stringSurroundedWithSingleQuote.append(stringSuffix);
        return stringSurroundedWithSingleQuote.toString();
    }
}