package io.github.orionlibs.orion.core.content;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.exception.Assert;

public class PersonRules extends Orion
{
    public static void isFirstNameValid(String firstName)
    {
        Assert.notEmpty(firstName, "firstName cannot be null/empty.");
        Assert.onlyAlphabetic(firstName, "firstName can only have letters.");
    }


    public static void isMiddleNameValid(String middleName)
    {
        Assert.onlyAlphabetic(middleName, "middleName can only have letters.");
    }


    public static void isLastNameValid(String lastName)
    {
        Assert.notEmpty(lastName, "lastName cannot be null/empty.");
        Assert.onlyAlphabetic(lastName, "lastName can only have letters.");
    }


    public static void isAgeValid(int age)
    {
        Assert.isPositive(age, "age cannot be <= 0.");
    }
}