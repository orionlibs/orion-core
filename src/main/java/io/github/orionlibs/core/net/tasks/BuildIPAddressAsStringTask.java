package io.github.orionlibs.core.net.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import java.util.Optional;

public class BuildIPAddressAsStringTask extends Orion
{
    public static Optional<String> run(byte[] IPAddress)
    {
        Byte x;
        String IPAddressString = "";

        if(IPAddress != null && IPAddress.length == 4)
        {
            IPAddressString = ConvertByteWithoutOverflowingToStringTask.run(IPAddressString, IPAddress[0]);
            IPAddressString += ".";
            IPAddressString = ConvertByteWithoutOverflowingToStringTask.run(IPAddressString, IPAddress[1]);
            IPAddressString += ".";
            IPAddressString = ConvertByteWithoutOverflowingToStringTask.run(IPAddressString, IPAddress[2]);
            IPAddressString += ".";
            IPAddressString = ConvertByteWithoutOverflowingToStringTask.run(IPAddressString, IPAddress[3]);
            return Optional.of(IPAddressString);
        }
        else
        {
            return Optional.empty();
        }

    }
}