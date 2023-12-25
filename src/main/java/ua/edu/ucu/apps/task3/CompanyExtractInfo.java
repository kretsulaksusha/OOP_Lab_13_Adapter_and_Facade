package ua.edu.ucu.apps.task3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CompanyExtractInfo {

    public static CompanyData extract(String url) {
        String name = "null", description = "null", logo = "null";

        try {
            org.jsoup.nodes.Document document = Jsoup.connect(url).get();

            // Name
            Elements names = document.getElementsContainingOwnText("©");
            if (!names.isEmpty()) {
                name = names.first().text();
            } else {
                name = document.title();
            }

            // Description
            Elements metaDescription = document.select("meta[name=description]");
            description = metaDescription.attr("content");

            // Logo
            Element logoElement = document.head().select("link[href~=.*\\.(ico|png|svg)]").first();
            if (logoElement != null) {
                logo = logoElement.attr("href");
                if (!logo.startsWith("http")) {
                    logo = document.baseUri() + logo;
                }
            } else {
                logoElement = document.head().select("meta[itemprop=image]").first();
                if (logoElement != null) {
                    logo = logoElement.attr("itemprop");
                    if (!logo.startsWith("http")) {
                        logo = document.baseUri() + logo;
                    }
                } else {
                    Elements logoElements = document.select("img[src*=logo], img[src*=brand]");
                    if (!logoElements.isEmpty()) {
                        logo = logoElements.first().absUrl("src");
                    } else {
                        logo = "Null";
                    }
                }
            }
        } catch (Exception e) {
            // e.printStackTrace();
            e.notify();
        }

        return CompanyData.builder()
                          .url(url)
                          .name(name)
                          .description(description)
                          .logo(logo)
                          .build();
    }

}
