package io.github.orionlibs.orion.core.string.tasks;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.string.StringsService;

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