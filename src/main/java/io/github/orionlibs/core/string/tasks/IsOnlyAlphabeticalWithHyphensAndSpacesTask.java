package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;

public class IsOnlyAlphabeticalWithHyphensAndSpacesTask extends Orion
{
    public static boolean run(String s)
    {
        Assert.notNull(s, "The string input cannot be null.");

        if(!s.isEmpty())
        {
            int numberOfLetters = 0;
            int numberOfHyphens = 0;
            int numberOfWhitespaces = 0;

            for(int i = 0; i < s.length(); i++)
            {

                if(Character.isLetter(s.charAt(i)))
                {
                    ++numberOfLetters;
                }
                else if('-' == s.charAt(i))
                {
                    ++numberOfHyphens;
                }
                else if(Character.isWhitespace(s.charAt(i)))
                {
                    ++numberOfWhitespaces;
                }

            }

            return numberOfLetters + numberOfHyphens + numberOfWhitespaces == s.length();
        }
        else
        {
            return false;
        }

    }
}