package com.ruenzuo.babel.helpers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.ruenzuo.babel.R;
import com.ruenzuo.babel.models.File;
import com.ruenzuo.babel.models.Language;
import com.ruenzuo.babel.models.Repository;

/**
 * Created by renzocrisostomo on 17/08/14.
 */
public class URLHelper {

    public static final String GITHUB_CLIENT_ID = "";
    public static final String GITHUB_CLIENT_SECRET = "";
    public static final String GITHUB_API_BASE_URL = "https://api.github.com/";

    public static String getURLStringForAuthorization() {
        return "https://github.com/login/oauth/authorize?client_id=" + GITHUB_CLIENT_ID;
    }

    public static String getURLStringForAccessToken(String code) {
        return "https://github.com/login/oauth/access_token?client_id=" + GITHUB_CLIENT_ID +
                "&client_secret=" + GITHUB_CLIENT_SECRET +
                "&code=" + code;
    }

    public static String getURLStringForTokenValidity(String token) {
        return GITHUB_API_BASE_URL + "applications/" + GITHUB_CLIENT_ID + "/tokens/" + token;
    }

    public static String getURLStringForRepositories(String query) {
        return GITHUB_API_BASE_URL + "search/repositories?" + query;
    }

    public static String getURLStringForFiles(Language language, Repository repository, String token) {
        return GITHUB_API_BASE_URL + "search/code?q=language:" + language.getSearch() + "+repo:" + repository.getName() + "&access_token=" + token;
    }

    public static String getURLStringForBlob(Repository repository, File file, String token) {
        return GITHUB_API_BASE_URL + "repos/" + repository.getName() + "/git/blobs/" + file.getSha() + "?access_token=" + token;
    }

    public static String getUserAgent(Context context) {
        return context.getString(R.string.app_name) + "/" + BabelUtils.getAppVersion(context);
    }

}
