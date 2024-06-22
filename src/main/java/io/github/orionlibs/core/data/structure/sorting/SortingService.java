package io.github.orionlibs.core.data.structure.sorting;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.data.structure.array.ArraySortService;
import io.github.orionlibs.core.data.structure.sorting.tasks.ReverseSortMapByKeyTask;
import io.github.orionlibs.core.data.structure.sorting.tasks.ReverseSortMapByValueTask;
import io.github.orionlibs.core.data.structure.sorting.tasks.SortMapByKeyTask;
import io.github.orionlibs.core.data.structure.sorting.tasks.SortMapByValueTask;
import io.github.orionlibs.core.exception.Assert;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortingService extends OrionService
{
    public static void sort(byte[] array)
    {
        ArraySortService.sort(array);
    }


    public static void sort(short[] array)
    {
        ArraySortService.sort(array);
    }


    public static void sort(int[] array)
    {
        ArraySortService.sort(array);
    }


    public static void sort(long[] array)
    {
        ArraySortService.sort(array);
    }


    public static void sort(float[] array)
    {
        ArraySortService.sort(array);
    }


    public static void sort(double[] array)
    {
        ArraySortService.sort(array);
    }


    public static void sort(char[] array)
    {
        ArraySortService.sort(array);
    }


    public static <T> void sort(T[] array)
    {
        ArraySortService.sort(array);
    }


    public static <T> void sort(T[] array, Comparator<T> comparator)
    {
        ArraySortService.<T>sort(array, comparator);
    }


    public static List<Entry<?, ?>> sortMapByKey(Map<?, ?> map)
    {
        Assert.notEmpty(map, "The given map input cannot be null/empty.");
        return SortMapByKeyTask.run(map);
    }


    public static List<Entry<?, ?>> sortMapByValue(Map<?, ?> map)
    {
        Assert.notEmpty(map, "The given map input cannot be null/empty.");
        return SortMapByValueTask.run(map);
    }


    public static List<Entry<?, ?>> sortMapByKeyDescending(Map<?, ?> map)
    {
        Assert.notEmpty(map, "The given map input cannot be null/empty.");
        return ReverseSortMapByKeyTask.run(map);
    }


    public static List<Entry<?, ?>> sortMapByValueDescending(Map<?, ?> map)
    {
        Assert.notEmpty(map, "The given map input cannot be null/empty.");
        return ReverseSortMapByValueTask.run(map);
    }
}