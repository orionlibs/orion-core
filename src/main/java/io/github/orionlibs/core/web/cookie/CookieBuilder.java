package io.github.orionlibs.core.web.cookie;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import org.springframework.http.ResponseCookie;

class CookieBuilder extends Orion
{
    static ResponseCookie createCookie(String cookieName, String cookieValue, int expirationInSeconds)
    {
        Assert.notNull(cookieName, "The cookieName input cannot be null.");
        ResponseCookie cookie = ResponseCookie.from(cookieName, cookieValue)
                        .domain(CookieDefaults.domain)
                        .httpOnly(CookieDefaults.HTTPOnly)
                        .maxAge(expirationInSeconds)
                        .path(CookieDefaults.path)
                        .sameSite(CookieDefaults.sameSite)
                        .secure(CookieDefaults.secure)
                        .build();
        return cookie;
    }
}