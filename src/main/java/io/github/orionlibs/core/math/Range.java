package io.github.orionlibs.core.math;

import io.github.orionlibs.core.abstraction.Orion;

public abstract class Range extends Orion
{
    private Number start;
    private Number end;
    private boolean leftInclusive;
    private boolean rightInclusive;


    public Range(Number start, Number end, boolean leftInclusive, boolean rightInclusive)
    {
        this.start = start;
        this.end = end;
        this.leftInclusive = leftInclusive;
        this.rightInclusive = rightInclusive;
    }


    public boolean isInclusive()
    {
        return isLeftInclusive() && isRightInclusive();
    }


    public boolean isExclusive()
    {
        return !isLeftInclusive() && !isRightInclusive();
    }


    public Number getStart()
    {
        return this.start;
    }


    public void setStart(Number start)
    {
        this.start = start;
    }


    public Number getEnd()
    {
        return this.end;
    }


    public void setEnd(Number end)
    {
        this.end = end;
    }


    public boolean isLeftInclusive()
    {
        return this.leftInclusive;
    }


    public void setLeftInclusive(boolean leftInclusive)
    {
        this.leftInclusive = leftInclusive;
    }


    public boolean isRightInclusive()
    {
        return this.rightInclusive;
    }


    public void setRightInclusive(boolean rightInclusive)
    {
        this.rightInclusive = rightInclusive;
    }
}