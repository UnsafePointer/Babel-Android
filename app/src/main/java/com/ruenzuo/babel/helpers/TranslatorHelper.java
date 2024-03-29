package com.ruenzuo.babel.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.ruenzuo.babel.models.File;
import com.ruenzuo.babel.models.Language;
import com.ruenzuo.babel.models.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renzocrisostomo on 17/08/14.
 */
public class TranslatorHelper {

    private Gson gson = new GsonBuilder().create();

    public static Map<String, String> translateToMap(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String[] values = param.split("=");
            String name = values[0];
            String value;
            if (values.length > 1) {
                value = values[1];
            } else {
                value = "";
            }
            map.put(name, value);
        }
        return map;
    }

    public static String translateToString(Map<String, String> map) {
        StringBuilder builder = new StringBuilder();
        for (String key : map.keySet()) {
            builder = builder.append(key).append("=").append(map.get(key));
            builder.append("&");
        }
        builder = builder.replace(builder.length() - 1, builder.length(), "");
        return builder.toString();
    }

    public Language[] translateLanguages(String file) {
        return gson.fromJson(file, Language[].class);
    }

    public Repository[] translateRepositories(JsonArray repositories) {
        return gson.fromJson(repositories, Repository[].class);
    }

    public File[] translateFiles(JsonArray repositories) {
        return gson.fromJson(repositories, File[].class);
    }

}
