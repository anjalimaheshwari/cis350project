package com.example.personalwellness;

public class Resource {
    private String name;
    private String image;
    private String summary;
    private String category;
    private String address;
    private String website;
    private double lat;
    private double lon;
    private String phonenumber;

    public Resource(String name, String image, String summary, String category,
                    String address, String website, double lat, double lon, String phonenumber) {
        this.name = name;
        this.image = image;
        this.summary = summary;
        this.category = category;
        this.address = address;
        this.website = website;
        this.lat = lat;
        this.lon = lon;
        this.phonenumber = phonenumber;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getSummary() {
        return summary;
    }

    public String getAddress() { return address; }

}
