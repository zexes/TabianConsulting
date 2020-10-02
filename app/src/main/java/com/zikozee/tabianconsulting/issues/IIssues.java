package com.zikozee.tabianconsulting.issues;


import com.zikozee.tabianconsulting.models.Issue;
import com.zikozee.tabianconsulting.models.Project;

import java.util.ArrayList;

/**
 * Created by User on 4/16/2018.
 */

public interface IIssues {

    void showProgressBar();

    void hideProgressBar();

    void buildSnackbar(String message);

    void getProjects();

    void deleteIssuesFromProject(ArrayList<Issue> issues, Project project);
}
