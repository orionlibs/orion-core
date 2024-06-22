package io.github.orionlibs.core.data.design_pattern.structural.adapter;

import io.github.orionlibs.core.abstraction.OrionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Adapter implements OrionInterface
{
    private Adaptable adaptableObject;
}
