package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.ImageNotFindException;
import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Repository.ImageRepository;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageService {

    private final Reader reader;
    private final RandomValues randomValues;
    private final PlaceService placeService;
    private final CityService cityService;
    private final ImageRepository imageRepository;

    public ImageService(Reader reader, RandomValues randomValues, PlaceService placeService, CityService cityService, ImageRepository imageRepository) {
        this.reader = reader;
        this.randomValues = randomValues;
        this.placeService = placeService;
        this.cityService = cityService;
        this.imageRepository = imageRepository;
    }

    public Image findImageById(Long id) {
        Optional<Image> imageById = imageRepository.findById(id);
        return imageById.orElseThrow(
                ()->new ImageNotFindException("Not found Image with given id: " + id));
    }

//    public List getImagesFromList(List <Image> imagesId){
//        List <Image> images = new ArrayList<>();
//        for(int i=0; i<imagesId.size(); i++){
//            images.add(findImageById(imagesId.get(i)));
//        }
//        return images;
//    }

    public String getRandomPlaceImage(String placeType){
        Place randomPlace= randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace(placeType));
        return randomImage(randomPlace.getImages()).getUrl();
    }

    public String getRandomCityImage(){
        City randomCity = randomValues.randomObjectFromList(cityService.getCities());
        Place randomPlace = randomValues.randomObjectFromList(randomCity.getPlaces());
        return randomImage(randomPlace.getImages()).getUrl();
    }


    public Image randomImage(List <Image> imagesId) {
        return randomValues.randomObjectFromList(imagesId);
    }
    public List getAllImages(){
        return imageRepository.findAll();
    }
}