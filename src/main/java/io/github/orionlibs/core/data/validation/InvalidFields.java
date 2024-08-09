package io.github.orionlibs.core.data.validation;

import java.util.HashSet;
import java.util.Set;
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
public class InvalidFields
{
    private Set<String> fields;


    public static InvalidFields of()
    {
        InvalidFields temp = new InvalidFields();
        temp.setFields(new HashSet<String>());
        return temp;
    }


    public void addField(String field)
    {
        fields.add(field);
    }


    public boolean isEmpty()
    {
        return fields != null && fields.isEmpty();
    }


    public boolean isNotEmpty()
    {
        return !isEmpty();
    }


    public void add(String field)
    {
        fields.add(field);
    }
}