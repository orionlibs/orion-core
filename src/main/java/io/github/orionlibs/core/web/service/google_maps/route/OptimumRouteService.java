package io.github.orionlibs.core.web.service.google_maps.route;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.math.MathService;
import io.github.orionlibs.core.string.StringsService;
import io.github.orionlibs.core.web.service.google_maps.GoogleMapsService;
import io.github.orionlibs.core.web.service.google_maps.OptimisedRouteBO;
import io.github.orionlibs.core.web.service.google_maps.model.DistanceAndTravelDurationModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OptimumRouteService extends OrionService
{
    public static OptimumRouteData getOptimumRouteForPostcodes(String startPostcodeToUse, String endPostcode, List<String> waypoints)
    {

        if(waypoints.size() <= 25)
        {
            List<String> invalidPostcodes = new ArrayList<>();
            List<String> route = createRouteForUpTo25Waypoints(startPostcodeToUse, endPostcode, waypoints);
            List<RecipientPostcodeData> recipientPostcodes = new ArrayList<>();
            int index = 0;
            float totalDistance = 0.0f;

            for(String waypoint : route)
            {
                float distanceFromStartingPostcodeOfRouteInMiles = 2.0f;

                //ignore the first and last postcodes since they are the start and end points
                if(index != 0 && index != route.size() - 1)
                {
                    DistanceAndTravelDurationModel distanceAndTravel = GoogleMapsService.getDistanceAndTravelDuration(startPostcodeToUse, waypoint);

                    if(distanceAndTravel != null)
                    {
                        distanceFromStartingPostcodeOfRouteInMiles = MathService.round(distanceAndTravel.getDistance(), 1);

                        if(distanceFromStartingPostcodeOfRouteInMiles < 0.1f)
                        {
                            distanceFromStartingPostcodeOfRouteInMiles = 0.1f;
                        }

                        totalDistance += distanceFromStartingPostcodeOfRouteInMiles;
                    }
                    else
                    {
                        invalidPostcodes.add(waypoint);
                    }

                }
                else
                {
                    distanceFromStartingPostcodeOfRouteInMiles = 0.1f;
                }

                String postcodePrefix = "";
                int indexOfSpaceInPostcode = waypoint.indexOf(" ");

                if(indexOfSpaceInPostcode != -1)
                {
                    postcodePrefix = waypoint.substring(0, indexOfSpaceInPostcode);
                }

                recipientPostcodes.add(RecipientPostcodeData.builder()
                                .postcode(waypoint)
                                .postcodeWithoutSpace(waypoint.replace(" ", ""))
                                .postcodePrefix(postcodePrefix)
                                .distanceFromStartPoint(distanceFromStartingPostcodeOfRouteInMiles)
                                .build());
                index++;
            }

            float averageDistance = totalDistance / (route.size() - 2 - invalidPostcodes.size());

            for(String invalidWaypoint : invalidPostcodes)
            {

                for(RecipientPostcodeData waypoint : recipientPostcodes)
                {

                    if(waypoint.getPostcodeWithoutSpace().equals(invalidWaypoint.replace(" ", "").toUpperCase()))
                    {
                        waypoint.setDistanceFromStartPoint(averageDistance);
                    }

                }

            }

            return OptimumRouteData.builder()
                            .route(route)
                            .recipients(recipientPostcodes)
                            .invalidPostcodes(invalidPostcodes)
                            .build();
        }
        else
        {
            return createRouteForMoreThan25Waypoints(startPostcodeToUse, endPostcode, waypoints);
        }

    }


    private static List<String> createRouteForUpTo25Waypoints(String startPostcodeToUse, String endPostcode, List<String> waypoints)
    {
        List<String> route = new LinkedList<>();
        List<String> invalidWaypointPostcodes = new ArrayList<>();
        List<String> formattedWaypointPostcodes = new ArrayList<>();

        for(String waypoint : waypoints)
        {

            if(waypoint.indexOf(" ") > 0)
            {
                formattedWaypointPostcodes.add(waypoint);
            }
            else
            {
                invalidWaypointPostcodes.add(waypoint.trim().toUpperCase());
            }

        }

        if(invalidWaypointPostcodes.size() == waypoints.size())
        {
            route.add(startPostcodeToUse);
            Collections.sort(waypoints);
            route.addAll(waypoints);
            route.add(endPostcode);
        }
        else
        {
            route = OptimisedRouteBO.of(startPostcodeToUse, endPostcode, formattedWaypointPostcodes).getRoute();

            if(!invalidWaypointPostcodes.isEmpty())
            {
                processInvalidPostcodesWithinRoute(waypoints, invalidWaypointPostcodes, route);
            }

        }

        return route;
    }


    private static void processInvalidPostcodesWithinRoute(List<String> waypoints, List<String> invalidWaypointPostcodes, List<String> route)
    {
        List<String> waypointsUnformatted = new ArrayList<>();
        waypoints.forEach(w -> waypointsUnformatted.add(w.replace(" ", "")));
        Collections.sort(waypointsUnformatted);

        for(int ind = invalidWaypointPostcodes.size() - 1; ind >= 0; ind--)
        {
            String invalidPostcode = invalidWaypointPostcodes.get(ind);
            int indexOfInvalidPostcodeInWaypoints = waypointsUnformatted.indexOf(invalidPostcode);
            boolean keepLookingForNextValidPostcode = true;
            int i = indexOfInvalidPostcodeInWaypoints;
            int indexIncrement = 1;

            while(keepLookingForNextValidPostcode)
            {
                boolean areThereMoreValidIncrementalIndices = true;
                boolean areThereMoreValidDecrementalIndices = true;
                double similarityScoreBetweenInvalidPostcodeAndLeftPostcode = 0.0f;
                double similarityScoreBetweenInvalidPostcodeAndRightPostcode = 0.0f;
                String nextFormattedPostcodeInWaypoints = null;
                String previousFormattedPostcodeInWaypoints = null;

                if(i + indexIncrement < waypointsUnformatted.size())
                {
                    String nextPostcodeInWaypoints = waypointsUnformatted.get(i + indexIncrement);
                    similarityScoreBetweenInvalidPostcodeAndRightPostcode = StringsService.getSimilarityPercentageBetween(invalidPostcode, nextPostcodeInWaypoints);
                    nextFormattedPostcodeInWaypoints = GoogleMapsService.getFormattedPostcode(nextPostcodeInWaypoints);
                }
                else
                {
                    areThereMoreValidIncrementalIndices = false;
                }

                if(keepLookingForNextValidPostcode)
                {

                    if(i - indexIncrement >= 0)
                    {
                        String previousPostcodeInWaypoints = waypointsUnformatted.get(i - indexIncrement);
                        similarityScoreBetweenInvalidPostcodeAndLeftPostcode = StringsService.getSimilarityPercentageBetween(invalidPostcode, previousPostcodeInWaypoints);
                        previousFormattedPostcodeInWaypoints = GoogleMapsService.getFormattedPostcode(previousPostcodeInWaypoints);
                    }
                    else
                    {
                        areThereMoreValidDecrementalIndices = false;
                    }

                    ++indexIncrement;
                }

                if(nextFormattedPostcodeInWaypoints != null && previousFormattedPostcodeInWaypoints != null)
                {

                    if(similarityScoreBetweenInvalidPostcodeAndRightPostcode > similarityScoreBetweenInvalidPostcodeAndLeftPostcode)
                    {

                        if(nextFormattedPostcodeInWaypoints.indexOf(" ") != -1)
                        {
                            route.add(route.indexOf(nextFormattedPostcodeInWaypoints), invalidPostcode);
                            keepLookingForNextValidPostcode = false;
                        }

                    }
                    else
                    {

                        if(previousFormattedPostcodeInWaypoints.indexOf(" ") != -1)
                        {
                            route.add(route.indexOf(previousFormattedPostcodeInWaypoints) + 1, invalidPostcode);
                            keepLookingForNextValidPostcode = false;
                        }

                    }

                }
                else if(nextFormattedPostcodeInWaypoints != null && previousFormattedPostcodeInWaypoints == null)
                {

                    if(nextFormattedPostcodeInWaypoints.indexOf(" ") != -1)
                    {
                        route.add(route.indexOf(nextFormattedPostcodeInWaypoints), invalidPostcode);
                        keepLookingForNextValidPostcode = false;
                    }

                }
                else if(nextFormattedPostcodeInWaypoints == null && previousFormattedPostcodeInWaypoints != null)
                {

                    if(previousFormattedPostcodeInWaypoints.indexOf(" ") != -1)
                    {
                        route.add(route.indexOf(previousFormattedPostcodeInWaypoints) + 1, invalidPostcode);
                        keepLookingForNextValidPostcode = false;
                    }

                }

                if(!areThereMoreValidIncrementalIndices && !areThereMoreValidDecrementalIndices)
                {
                    keepLookingForNextValidPostcode = false;
                }

            }

        }

    }


    private static OptimumRouteData createRouteForMoreThan25Waypoints(String startPostcode, String endPostcode, List<String> waypoints)
    {
        List<String> route = new LinkedList<>();
        List<String> invalidPostcodes = new ArrayList<>();
        List<RecipientPostcodeData> recipientPostcodes = new ArrayList<>();
        float totalDistance = 0.0f;

        for(String waypoint : waypoints)
        {

            if(waypoint.indexOf(" ") > 0)
            {
                float distanceFromStartingPostcodeOfRouteInMiles = 2.0f;
                DistanceAndTravelDurationModel distanceAndTravel = GoogleMapsService.getDistanceAndTravelDuration(startPostcode, waypoint);

                if(distanceAndTravel != null)
                {
                    distanceFromStartingPostcodeOfRouteInMiles = MathService.round(distanceAndTravel.getDistance(), 1);

                    if(distanceFromStartingPostcodeOfRouteInMiles < 0.1f)
                    {
                        distanceFromStartingPostcodeOfRouteInMiles = 0.1f;
                    }

                    totalDistance += distanceFromStartingPostcodeOfRouteInMiles;
                }

                recipientPostcodes.add(RecipientPostcodeData.builder()
                                .postcode(waypoint)
                                .postcodeWithoutSpace(waypoint.replace(" ", ""))
                                .postcodePrefix(waypoint.substring(0, waypoint.indexOf(" ")))
                                .distanceFromStartPoint(distanceFromStartingPostcodeOfRouteInMiles)
                                .build());
            }
            else
            {
                String waypointTemp = waypoint.trim().toUpperCase();
                invalidPostcodes.add(waypointTemp);
            }

        }

        if(invalidPostcodes.size() == waypoints.size())
        {
            route.add(startPostcode);
            Collections.sort(waypoints);
            route.addAll(waypoints);
            route.add(endPostcode);
        }
        else
        {
            Map<String, List<RecipientPostcodeData>> postcodePrefixToRecipientMapper = new HashMap<>();

            for(RecipientPostcodeData recipient : recipientPostcodes)
            {

                if(postcodePrefixToRecipientMapper.get(recipient.getPostcodePrefix()) != null)
                {
                    postcodePrefixToRecipientMapper.get(recipient.getPostcodePrefix()).add(recipient);
                }
                else
                {
                    List<RecipientPostcodeData> temp = new ArrayList<>();
                    temp.add(recipient);
                    postcodePrefixToRecipientMapper.put(recipient.getPostcodePrefix(), temp);
                }

            }

            List<RecipientPostcodeGroupByPrefixData> groups = new ArrayList<>();

            for(Map.Entry<String, List<RecipientPostcodeData>> entry : postcodePrefixToRecipientMapper.entrySet())
            {
                Collections.sort(entry.getValue(), new RecipientPostcodeComparator());
                groups.add(RecipientPostcodeGroupByPrefixData.builder()
                                .postcodes(entry.getValue())
                                .postcodePrefix(entry.getKey())
                                .build());
            }

            if(groups.size() == 1)
            {
                List<List<RecipientPostcodeData>> subgroups = new ArrayList<>();

                for(int i = 0; i < groups.get(0).getPostcodes().size(); i++)
                {

                    if(i % 25 == 0)
                    {
                        subgroups.add(new ArrayList<RecipientPostcodeData>());
                    }

                    subgroups.get(subgroups.size() - 1).add(groups.get(0).getPostcodes().get(i));
                }

                for(int i = 0; i < subgroups.size(); i++)
                {
                    List<String> ithWaypoints = subgroups.get(i)
                                    .stream()
                                    .map(e -> e.getPostcode())
                                    .collect(Collectors.toList());
                    List<String> ithRoute = new ArrayList<>();

                    if(subgroups.size() == 1)
                    {
                        ithRoute = createRouteForUpTo25Waypoints(startPostcode, endPostcode, ithWaypoints);
                        route.addAll(ithRoute);
                    }
                    else
                    {

                        if(i == 0)
                        {

                            if(i == subgroups.size() - 1)
                            {
                                ithRoute = createRouteForUpTo25Waypoints(startPostcode, endPostcode, ithWaypoints);
                            }
                            else
                            {
                                ithRoute = createRouteForUpTo25Waypoints(startPostcode, subgroups.get(i + 1).get(0).getPostcode(), ithWaypoints);
                            }

                            route.addAll(ithRoute);
                        }
                        else if(i < subgroups.size() - 1)
                        {
                            ithWaypoints = ithWaypoints.subList(1, ithWaypoints.size());
                            ithRoute = createRouteForUpTo25Waypoints(subgroups.get(i).get(0).getPostcode(), subgroups.get(i + 1).get(0).getPostcode(), ithWaypoints);
                            route.addAll(ithRoute.subList(1, ithRoute.size()));
                        }
                        else
                        {
                            ithWaypoints = ithWaypoints.subList(1, ithWaypoints.size());
                            ithRoute = createRouteForUpTo25Waypoints(subgroups.get(i).get(0).getPostcode(), endPostcode, ithWaypoints);
                            route.addAll(ithRoute.subList(1, ithRoute.size()));
                        }

                    }

                }

            }
            else
            {

                for(RecipientPostcodeGroupByPrefixData group : groups)
                {
                    float sumOfDistancesWithinGroup = group.getPostcodes()
                                    .stream()
                                    .map(postcode -> postcode.getDistanceFromStartPoint())
                                    .reduce(0.0f, (d1, d2) -> d1 + d2);
                    group.setSumOfDistancesWithinGroup(sumOfDistancesWithinGroup);
                }

                Collections.sort(groups, new RecipientGroupSumOfDistancesFromStartPointComparator());

                for(int i = 0; i < groups.size(); i++)
                {
                    List<String> ithWaypoints = groups.get(i).getPostcodes()
                                    .stream()
                                    .map(p -> p.getPostcode())
                                    .collect(Collectors.toList());
                    List<String> ithRoute = new ArrayList<>();

                    if(groups.size() == 1)
                    {
                        route.addAll(createRouteForUpTo25Waypoints(startPostcode, endPostcode, ithWaypoints));
                    }
                    else
                    {

                        if(i == 0)
                        {

                            if(i == groups.size() - 1)
                            {
                                route.addAll(createRouteForUpTo25Waypoints(startPostcode, endPostcode, ithWaypoints));
                            }
                            else
                            {
                                route.addAll(createRouteForUpTo25Waypoints(startPostcode, groups.get(i + 1).getPostcodes().get(0).getPostcode(), ithWaypoints));
                            }

                        }
                        else if(i < groups.size() - 1)
                        {
                            ithWaypoints = ithWaypoints.subList(1, ithWaypoints.size());
                            ithRoute = createRouteForUpTo25Waypoints(groups.get(i).getPostcodes().get(0).getPostcode(), groups.get(i + 1).getPostcodes().get(0).getPostcode(), ithWaypoints);
                            route.addAll(ithRoute.subList(1, ithRoute.size()));
                        }
                        else
                        {
                            ithWaypoints = ithWaypoints.subList(1, ithWaypoints.size());
                            ithRoute = createRouteForUpTo25Waypoints(groups.get(i).getPostcodes().get(0).getPostcode(), endPostcode, ithWaypoints);
                            route.addAll(ithRoute.subList(1, ithRoute.size()));
                        }

                    }

                }

            }

            processInvalidPostcodesWithinRoute(waypoints, invalidPostcodes, route);
        }

        float averageDistance = totalDistance / (route.size() - 2 - invalidPostcodes.size());

        for(String invalidWaypoint : invalidPostcodes)
        {

            for(RecipientPostcodeData waypoint : recipientPostcodes)
            {

                if(waypoint.getPostcodeWithoutSpace().equals(invalidWaypoint.replace(" ", "").toUpperCase()))
                {
                    waypoint.setDistanceFromStartPoint(averageDistance);
                }

            }

        }

        return OptimumRouteData.builder()
                        .route(route)
                        .recipients(recipientPostcodes)
                        .invalidPostcodes(invalidPostcodes)
                        .build();
    }
}