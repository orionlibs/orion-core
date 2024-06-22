package io.github.orionlibs.core.data.geodata.continent.data_access;

import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.object.CloningService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This class does not extend OrionModel, because that inheritance does not
// allow
// the use of Lombok's @SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ContinentModel implements OrionModel
{
    private String continentCode;
    private String continentName;


    public static ContinentModel of()
    {
        return ContinentModel.builder().build();
    }


    public static ContinentModel of(String continentCode)
    {
        return ContinentModel.builder().continentCode(continentCode).build();
    }


    @Override
    public ContinentModel clone()
    {
        return (ContinentModel)CloningService.clone(this);
    }


    @Override
    public ContinentModel getCopy()
    {
        return this.clone();
    }
}