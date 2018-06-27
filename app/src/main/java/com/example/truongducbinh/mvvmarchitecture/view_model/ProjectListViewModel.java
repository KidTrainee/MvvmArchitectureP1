package com.example.truongducbinh.mvvmarchitecture.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.truongducbinh.mvvmarchitecture.service.model.Project;
import com.example.truongducbinh.mvvmarchitecture.service.repository.ProjectRepository;

import java.util.List;

public class ProjectListViewModel extends AndroidViewModel {

    private final LiveData<List<Project>> projectListObservable;

    public ProjectListViewModel(ProjectRepository projectRepository, @NonNull Application application) {
        super(application);
        // getProjectList(“Google”) to retrieve Google GitHub projects
        projectListObservable = projectRepository.getProjectList("Google");
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
