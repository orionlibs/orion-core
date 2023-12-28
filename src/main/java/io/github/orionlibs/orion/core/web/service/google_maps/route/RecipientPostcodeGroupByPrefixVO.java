package io.github.orionlibs.orion.core.web.service.google_maps.route;

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
public class RecipientPostcodeGroupByPrefixVO
{
    private List<RecipientPostcodeVO> postcodes;
    private String postcodePrefix;
    //private float maximumDistanceWithinGroup;
    private float sumOfDistancesWithinGroup;
}