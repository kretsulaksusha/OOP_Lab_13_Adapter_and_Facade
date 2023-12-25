package ua.edu.ucu.apps.task3;

import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class CompanyData {
    private String url;
    private String name;
    private String description;
    private String logo;
}
