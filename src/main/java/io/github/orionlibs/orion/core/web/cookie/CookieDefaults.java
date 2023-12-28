package io.github.orionlibs.orion.core.web.cookie;

import io.github.orionlibs.orion.core.abstraction.Orion;

class CookieDefaults extends Orion
{
    public static final String domain = Orion.domainName;
    public static final String path = "/";
    public static final String sameSite = "None";
    public static final boolean HTTPOnly = true;
    public static final boolean secure = true;
}