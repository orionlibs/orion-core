package io.github.orionlibs.core.data.user.password;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.configuration.ConfigurationService;
import io.github.orionlibs.core.cryptology.encoding.base64.Base64EncodingService;
import io.github.orionlibs.core.cryptology.encryption.bcrypt.BCryptEncryptionService;
import io.github.orionlibs.core.string.StringsService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordService extends OrionService
{
    public static String generate(int length, boolean useSymbols)
    {
        return StringsService.generateRandomString(length, useSymbols);
    }


    public static String encrypt(String rawPassword)
    {
        return BCryptEncryptionService.encrypt(rawPassword);
    }


    public static boolean doesPasswordMatchEncryptedOne(String rawPassword, String encryptedPassword)
    {
        return BCryptEncryptionService.matches(rawPassword, encryptedPassword);
    }


    public static boolean isValid(String password)
    {
        String passwordPattern = ConfigurationService.getProp("user.management.registration.password.pattern");
        String decodedPasswordPattern = Base64EncodingService.decodeBase64ForString(passwordPattern);
        Pattern pattern = Pattern.compile(decodedPasswordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}