package com.pijiuji.util;

import java.util.Comparator;

public class MapKeyComparator implements Comparator {

    MapKeyComparator()
    {
    }

    public int compare(String str1, String str2)
    {
        return str1.compareTo(str2);
    }

    @Override
    public int compare(Object obj, Object obj1)
    {
        return compare((String)obj, (String)obj1);
    }
}
