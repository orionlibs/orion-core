package io.github.orionlibs.core.web.service.google_maps.route;

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
public class RecipientPostcodeData
{
    private String postcode;
    private String postcodeWithoutSpace;
    private String postcodePrefix;
    private float distanceFromStartPoint;
}