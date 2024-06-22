package io.github.orionlibs.core.web.urls;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.string.StringsService;
import lombok.Builder;
import org.springframework.web.util.UriComponentsBuilder;

// @NoArgsConstructor
// @AllArgsConstructor
@Builder
//@Getter
//@Setter
class URLEncoder extends Orion
{
    String encodeWithUTF8(String url)
    {
        return UriComponentsBuilder.fromUriString(url).build().encode().toUri().toString();
    }


    String encodeRemovingSymbolsWithUTF8(String url)
    {
        return encodeWithUTF8(StringsService.deleteSymbolCharacters(url));
    }


    String encodeRemovingSymbolsExceptForHyphenAndSpaceWithUTF8(String url)
    {
        return encodeWithUTF8(StringsService.deleteSymbolCharactersExceptForHyphenAndSpace(url));
    }
}