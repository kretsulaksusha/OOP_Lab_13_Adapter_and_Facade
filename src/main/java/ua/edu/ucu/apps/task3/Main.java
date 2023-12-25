package ua.edu.ucu.apps.task3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://dictionary.cambridge.org";
        CompanyData companyData = CompanyExtractInfo.extract(url);

        System.out.println("URL: " + companyData.getUrl());
        System.out.println("Name: " + companyData.getName());
        System.out.println("Description: " + companyData.getDescription());
        System.out.println("Logo URL: " + companyData.getLogo());
    }
}
