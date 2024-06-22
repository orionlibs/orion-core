package io.github.orionlibs.core.web.service.google_maps.route;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OptimumRouteData
{
    private List<RecipientPostcodeData> recipients;
    private List<String> route;
    private List<String> invalidPostcodes;
}