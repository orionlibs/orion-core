package io.github.orionlibs.core.data.geodata;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.data.geodata.postcode.data_access.PostcodeVoterModel;
import io.github.orionlibs.core.data.geodata.postcode.data_access.PostcodeVotersDAO;
import java.util.List;

public class GeodataService extends OrionService
{
    public static boolean voteForPostcode(String postcodeToVoteFor, String postcodePrefix, String emailAddressOfVoter)
    {
        return PostcodeVoteBO.of(postcodeToVoteFor, postcodePrefix, emailAddressOfVoter).vote();
    }


    public static List<PostcodeVoterModel> getAllVotesForPostcodes()
    {
        return PostcodeVotersDAO.getPostcodeVoters();
    }
}