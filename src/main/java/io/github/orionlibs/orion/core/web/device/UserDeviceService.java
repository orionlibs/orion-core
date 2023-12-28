package io.github.orionlibs.orion.core.web.device;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import javax.servlet.http.HttpServletRequest;

public class UserDeviceService extends OrionService
{
    public static int resolveDevice(HttpServletRequest request)
    {
        return UserDeviceResolver.resolveDeviceType(request);
    }
}