package com.starcor.hunan.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author xiesheng
 * The config setting for the test
 *
 */

public class MyConfig
{

    
    public static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME="com.starcor.hunan.SplashActivity";
    
    public static HashMap<String, int[]> pos_map;
    
    static
    {

        pos_map = new HashMap<String, int[]> ();
        pos_map.put("1", new int[] { -1, 1 });
        pos_map.put("2", new int[] { 0, 1 });
        pos_map.put("3", new int[] { 1, 1 });
        pos_map.put("4", new int[] { -1, 0 });
        pos_map.put("5", new int[] { 0, 0 });
        pos_map.put("6", new int[] { 1, 0 });
        pos_map.put("7", new int[] { -1, -1 });
        pos_map.put("8", new int[] { 0, -1 });
        pos_map.put("9", new int[] { 1, -1 });

    }

    public static Map<String, List> key_map;
    static
    {

        key_map = new HashMap<String, List>();
        List<String> list = new ArrayList<String>();
        list.add("1");
        key_map.put("1", list);

        list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("2");
        key_map.put("2", list);

        list = new ArrayList<String>();
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("3");
        key_map.put("3", list);

        list = new ArrayList<String>();
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("4");
        key_map.put("4", list);


        list = new ArrayList<String>();
        list.add("J");
        list.add("K");
        list.add("L");
        list.add("5");
        key_map.put("5", list);


        list = new ArrayList<String>();
        list.add("M");
        list.add("N");
        list.add("O");
        list.add("6");
        key_map.put("6", list);

        list = new ArrayList<String>();
        list.add("P");
        list.add("Q");
        list.add("R");
        list.add("S");
        list.add("7");
        key_map.put("7", list);

        list = new ArrayList<String>();
        list.add("T");
        list.add("U");
        list.add("V");
        list.add("8");
        key_map.put("8", list);

        list = new ArrayList<String>();
        list.add("W");
        list.add("X");
        list.add("Y");
        list.add("Z");
        list.add("9");
        key_map.put("9", list);

    }

}
