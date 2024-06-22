package io.github.orionlibs.core.abstraction;

import io.github.orionlibs.core.object.CloningService;

public class OrionRequestModel implements OrionModel
{
    public OrionRequestModel()
    {
    }


    @Override
    public OrionRequestModel clone()
    {
        return (OrionRequestModel)CloningService.clone(this);
    }


    @Override
    public OrionRequestModel getCopy()
    {
        return this.clone();
    }
}