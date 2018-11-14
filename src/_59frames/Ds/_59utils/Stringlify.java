package _59frames.Ds._59utils;

import java.util.Map;

public final class Stringlify {

    private Stringlify(){

    }

    public static String stringlify(String str, Object... v){
        for (int i = 0; i < v.length; i++) {
            str = str.replace("{"+i+"}", v[i].toString());
        }
        return str;
    }

    public static String stringlify(String str, Map<String, Object> map){
        final String[] strArr = new String[1];
        strArr[0] = str;
        map.forEach((key, value) -> strArr[0] = strArr[0].replace("{"+key+"}", value.toString()));
        return strArr[0];
    }
}
