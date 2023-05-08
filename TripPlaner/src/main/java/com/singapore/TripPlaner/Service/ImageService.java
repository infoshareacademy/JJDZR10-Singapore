package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.ImageNotFindException;
import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    private final Reader reader;
    private final RandomValues randomValues;
    private final PlaceService placeService;
    private final CityService cityService;

    public ImageService(Reader reader, RandomValues randomValues, PlaceService placeService, CityService cityService) {
        this.reader = reader;
        this.randomValues = randomValues;
        this.placeService = placeService;
        this.cityService = cityService;
    }

    public Image findImageById(long id) {
        return (Image) reader.getList(Image.class).stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .orElseThrow(()-> new ImageNotFindException("Not found Image with given id: " + id));
    }

    public List getImagesFromList(List <Double> imagesId){
        List <Image> images = new ArrayList<>();
        for(int i=0; i<imagesId.size(); i++){
            images.add(findImageById(Double.valueOf(imagesId.get(i)).longValue()));
        }
        return images;
    }

    public String getRandomPlaceImage(String placeType){
        Places randomPlace= (Places) randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace(placeType));
        return randomImage(randomPlace.getImages()).getUrl();
    }

    public String getRandomCityImage(){
        City randomCity = (City) randomValues.randomObjectFromList(cityService.getAllCities());
        return randomImage(randomCity.getImages()).getUrl();

    }

    public Image getRandomImage(List inputImagesList) {
        Image image = (Image) randomValues.randomObjectFromList(inputImagesList);
        return image;
    }

    private Image randomImage(List imagesId) {
        double imageId = (double) randomValues.randomObjectFromList(imagesId);
        return findImageById(Double.valueOf(imageId).longValue());
    }
    public List getAllImages(){
        return reader.getList(Image.class);
    }
}