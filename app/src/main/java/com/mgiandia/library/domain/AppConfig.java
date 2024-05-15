package com.mgiandia.library.domain;

public class AppConfig {
    private static AppConfig instance;

    private String isWorkingWith;

    private AppConfig() {
        // Private constructor to enforce singleton pattern
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String isWorkingWithTasks() {
        return isWorkingWith;
    }

    public void setWorkingWithTasks(String workingWith) {
        isWorkingWith = workingWith;
    }
}
