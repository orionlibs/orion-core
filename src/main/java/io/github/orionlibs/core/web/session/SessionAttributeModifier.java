package io.github.orionlibs.core.web.session;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import jakarta.servlet.http.HttpServletRequest;

class SessionAttributeModifier extends Orion
{
    static void setAttribute(HttpServletRequest request, String attributeName, Object attributeValue)
    {
        Assert.notNull(request, "The HttpServletRequest input cannot be null.");
        request.setAttribute(attributeName, attributeValue);
    }
}