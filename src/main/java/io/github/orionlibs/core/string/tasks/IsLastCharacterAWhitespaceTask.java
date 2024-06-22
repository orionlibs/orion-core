package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.string.StringsService;

public class IsLastCharacterAWhitespaceTask extends Orion
{
    public static boolean run(String aString)
    {
        boolean isLastCharacterAWhitespace = false;
        String lastCharacter = StringsService.getLastCharacterAsString(aString);

        if(StringsService.isWhitespace(lastCharacter))
        {
            isLastCharacterAWhitespace = true;
        }

        return isLastCharacterAWhitespace;
    }
}