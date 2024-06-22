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
public class PostcodeVoteModel implements OrionModel
{
    private String postcodeWithoutSpace;
    private String postcodePrefix;
    private long numberOfVotes;


    public static PostcodeVoteModel of()
    {
        return PostcodeVoteModel.builder().build();
    }


    public static PostcodeVoteModel of(String postcodeWithoutSpace)
    {
        return PostcodeVoteModel.builder().postcodeWithoutSpace(postcodeWithoutSpace).build();
    }


    @Override
    public PostcodeVoteModel clone()
    {
        return (PostcodeVoteModel)CloningService.clone(this);
    }


    @Override
    public PostcodeVoteModel getCopy()
    {
        return this.clone();
    }
}