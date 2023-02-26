package com.bauet.learningproject.models;

public class RecyclerViewModel {

    String placeName;
    String country;
    String place_location;
    int image;

    public RecyclerViewModel(String placeName, String country, String place_location, int image) {
        this.placeName = placeName;
        this.country = country;
        this.place_location = place_location;
        this.image = image;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getCountry() {
        return country;
    }

    public String getLocationOfPlace() {
        return place_location;
    }

    public int getImage() {
        return image;
    }
}
