package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Exception.ImageNotFindException;
import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Repository.ImageRepository;
import org.springframework.stereotype.Service;
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

    public String getRandomPlaceImage(String placeType){

        Place randomPlace= randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace(placeType));
        List<Image> images = randomPlace.getImages();
        if(images.isEmpty()) {
            return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwRvkNkCk8LG-MgmgYtJ3n5dGakK-idcI61uvQH1pqBQ&s";
        } else {
            return randomImage(images).getUrl();
        }
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

    public void savePlaceForImage(Image image, Place place){
        image.setPlace(place);
        saveImage(image);
    }

    public void saveCityForImage(Image image, City city){
        image.setCity(city);
        saveImage(image);
    }
}