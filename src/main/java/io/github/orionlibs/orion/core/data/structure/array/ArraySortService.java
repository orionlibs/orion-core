package io.github.orionlibs.orion.core.data.structure.array;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import java.util.Arrays;
import java.util.Comparator;

public class ArraySortService<T> extends OrionService
{
    public static void sort(byte[] array)
    {
        Arrays.sort(array);
    }


    public static void sort(short[] array)
    {
        Arrays.sort(array);
    }


    public static void sort(int[] array)
    {
        Arrays.sort(array);
    }


    public static void sort(long[] array)
    {
        Arrays.sort(array);
    }


    public static void sort(float[] array)
    {
        Arrays.sort(array);
    }


    public static void sort(double[] array)
    {
        Arrays.sort(array);
    }


    public static void sort(char[] array)
    {
        Arrays.sort(array);
    }


    public static <T> void sort(T[] array)
    {
        Arrays.sort(array);
    }


    public static <T> void sort(T[] array, Comparator<T> comparator)
    {
        Arrays.sort(array, comparator);
    }
}