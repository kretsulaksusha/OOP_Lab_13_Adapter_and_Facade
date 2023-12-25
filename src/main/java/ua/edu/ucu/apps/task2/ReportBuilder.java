package ua.edu.ucu.apps.task2;

import lombok.Getter;

@Getter
public class ReportBuilder {
    private БазаДаних db;
    public ReportBuilder(БазаДаних db) {
        this.db = db;
    }
}
