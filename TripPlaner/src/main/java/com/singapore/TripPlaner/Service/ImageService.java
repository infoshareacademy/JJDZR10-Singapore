package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service


public class ImageService {
    private final Image image;
    private List imagesList;
    private final Reader reader;
    private final Writer writer;
    private final PlaceService placeService;
    private final CityService cityService;
    private final RandomValues randomValues;

    public ImageService(Image image, Reader reader, Writer writer, PlaceService placeService, CityService cityService, RandomValues randomValues) {
        this.image = image;
        this.reader = reader;
        this.writer = writer;
        this.placeService = placeService;
        this.cityService = cityService;
        this.randomValues = randomValues;
    }


    public Image findImageById (long id){
        Image image =  (Image) reader.getObjectById(Image.class, id);
        return image;
    }

    public City getObjectByImageId(double imageId) throws NullPointerException {
        List<Persistent> cityList =  reader.getList(City.class);
        City cityByImageId = null;
        for (int i = 0; i < cityList.size(); i++) {
            cityByImageId = (City) cityList.get(i);
            List imagesList = cityByImageId.getImages();
            if (imagesList.contains(imageId)) {
                break;
            }
        }
        return cityByImageId;
    }
    public List randomPlaceImages(int numberOfImages, long placeId){
        Places place = placeService.findById(placeId);
        List inputList =  place.getImages();
        RandomValues randomValues = new RandomValues();
        return randomValues.outputList(numberOfImages, inputList);
    }

    public void randomPlaceImageAttributes(Model model, long id, int numberOfRandomImages) {
        List imagesId = randomPlaceImages(numberOfRandomImages, id);
        Image image = findImageById(Double.valueOf((Double) imagesId.get(0)).longValue());
        model.addAttribute("image", image);
    }

    public Image getRandomImage (){
       Image image = (Image) randomValues.randomObjectFromList(getImages());
        return image;
    }


    public void setUrl (String url){
        Image image = new Image();
        image.setUrl(url);
        writer.save(image);
    }

    public List getImages(){
        return imagesList = reader.getList(Image.class);
    }


    public List getImagesList() {
        return imagesList;
    }

    public void setImagesList(List imagesList) {
        this.imagesList = imagesList;
    }


}