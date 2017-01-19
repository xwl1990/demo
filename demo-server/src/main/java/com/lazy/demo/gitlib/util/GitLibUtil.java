package com.lazy.demo.gitlib.util;

import java.io.IOException;

import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabSession;

public class GitLibUtil {

    
   
    
    public static GitlabAPI get() {
         try {
             GitlabSession session = GitlabAPI.connect("", "", "");
        } catch (IOException e) {
            	
        }
         return null;
    }
}

	