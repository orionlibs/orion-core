package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.data.structure.list.OrionList;
import io.github.orionlibs.core.data.structure.list.type.OrionArrayList;
import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.math.RandomNumberGenerationService;
import java.util.Collections;
import java.util.stream.IntStream;

public class GenerateRandomNumericCodeTask extends Orion
{
    private static final char[] allCharacters;
    static
    {
        allCharacters = new char[]
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        shuffleCharacters();
    }


    private static void shuffleCharacters()
    {
        OrionList<Character> charactersTemp = OrionArrayList.of(allCharacters.length);

        for(char character : allCharacters)
        {
            charactersTemp.append(character);
        }

        Collections.shuffle(charactersTemp);

        for(int i = 0; i < charactersTemp.size(); i++)
        {
            allCharacters[i] = charactersTemp.get(i);
        }

    }


    public static String run(int length)
    {
        Assert.isPositive(length, "length has to be >= 1");
        StringBuilder sb = new StringBuilder();
        IntStream indexStream = IntStream.range(0, length);
        indexStream.forEach(i -> sb.append(allCharacters[RandomNumberGenerationService.getRandomInteger(allCharacters.length)]));
        return sb.toString();
    }
}