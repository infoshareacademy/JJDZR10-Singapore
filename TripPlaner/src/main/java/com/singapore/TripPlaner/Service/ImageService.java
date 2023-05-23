package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.ImageNotFindException;
import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private final RandomValues randomValues;
    private final PlaceService placeService;
    private final CityService cityService;
    private final ImageRepository imageRepository;

    public ImageService(RandomValues randomValues, PlaceService placeService, CityService cityService, ImageRepository imageRepository) {
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

    public List<Image> getAllImageForCity(City city){
        List <Place> placeListForCity = city.getPlaces();
        List <Image> allImagesForCity = new ArrayList<>();
        for (Place place : placeListForCity) {
            for (Image image : place.getImages()) {
                allImagesForCity.add(image);
            }
        }
//       Place randomPlaceForCity =  getRandomPlaceForCity(city);
//       List<Image> imagesForPlace = randomPlaceForCity.getImages();
//       List <String> urlList = placeListForCity.stream().map(Image::getUrl).collect(Collectors.toList());
        return allImagesForCity;
    }


    public String getRandomPlaceImage(String placeType){
        Place randomPlace= randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace(placeType));
        return randomImage(randomPlace.getImages()).getUrl();
    }

    public String getRandomCityImage(){
        City randomCity = getRandomCity();
        Place randomPlaceFromCity = getRandomPlaceForCity(randomCity);
        return randomImage(randomPlaceFromCity.getImages()).getUrl();
    }

    private City getRandomCity() {
        return randomValues.randomObjectFromList(cityService.getCities());
    }

    private Place getRandomPlaceForCity(City randomCity) {
        return  randomValues.randomObjectFromList(randomCity.getPlaces());
    }

    public Image randomImage(List <Image> imagesId) {
        return randomValues.randomObjectFromList(imagesId);
    }
    public List getAllImages(){
        return imageRepository.findAll();
    }

    public Image saveImage(Image image){
        return imageRepository.save(image);
    }
    public Image savePlaceForImage(Image image, Place place){
        image.setPlace(place);
        return saveImage(image);
    }
}