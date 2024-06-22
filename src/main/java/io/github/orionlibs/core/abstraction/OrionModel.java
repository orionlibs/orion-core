package io.github.orionlibs.core.abstraction;

import java.io.Serializable;
import net.minidev.json.annotate.JsonIgnore;

public interface OrionModel extends Cloneable, Serializable
{
    @JsonIgnore
    public abstract OrionModel getCopy();
}