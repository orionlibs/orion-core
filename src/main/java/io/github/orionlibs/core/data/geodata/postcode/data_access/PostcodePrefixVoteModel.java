package io.github.orionlibs.core.data.geodata.postcode.data_access;

import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.object.CloningService;
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
public class PostcodePrefixVoteModel implements OrionModel
{
    private String postcodePrefix;
    private long numberOfVotes;


    public static PostcodePrefixVoteModel of()
    {
        return PostcodePrefixVoteModel.builder().build();
    }


    public static PostcodePrefixVoteModel of(String postcodePrefix)
    {
        return PostcodePrefixVoteModel.builder().postcodePrefix(postcodePrefix).build();
    }


    @Override
    public PostcodePrefixVoteModel clone()
    {
        return (PostcodePrefixVoteModel)CloningService.clone(this);
    }


    @Override
    public PostcodePrefixVoteModel getCopy()
    {
        return this.clone();
    }
}