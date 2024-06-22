package io.github.orionlibs.core.web.device;

import io.github.orionlibs.core.abstraction.OrionService;
import jakarta.servlet.http.HttpServletRequest;

public class UserDeviceService extends OrionService
{
    public static int resolveDevice(HttpServletRequest request)
    {
        return UserDeviceResolver.resolveDeviceType(request);
    }
}