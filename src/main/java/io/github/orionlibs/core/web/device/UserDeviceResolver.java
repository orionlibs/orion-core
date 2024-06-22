package io.github.orionlibs.core.web.device;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.web.app.header.HTTPHeader;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserDeviceResolver extends Orion
{
    public static int resolveDeviceType(HttpServletRequest request)
    {
        String userAgent = request.getHeader(HTTPHeader.UserAgent.get());

        if(userAgent != null)
        {
            userAgent = userAgent.toLowerCase();

            if(UserDeviceResolverHelper.isTabletDevice(userAgent))
            {
                return UserDeviceType.TABLET;
            }
            else if(UserDeviceResolverHelper.isMobileDevice(userAgent, request))
            {
                return UserDeviceType.MOBILE;
            }

        }

        return UserDeviceType.DESKTOP;
    }
}