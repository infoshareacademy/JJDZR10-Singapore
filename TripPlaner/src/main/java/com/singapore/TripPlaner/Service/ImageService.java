package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class ImageService implements ImageInterface {
    private final Image image;
    private List imagesList;
    private final Reader reader;
    private final Writer writer;
    private final PlaceService placeService;

    public ImageService(Image image, Reader reader, Writer writer, PlaceService placeService) {
        this.image = image;
        this.reader = reader;
        this.writer = writer;
        this.placeService = placeService;
    }


    public Image findImageById (long id){
        Image image =  (Image) reader.getObjectById(Image.class, id);
        return image;
    }

    public City getPlaceByImageId(double imageId) throws NullPointerException {
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
    public List randomImages (int numberOfImages, long placeId){
        Places place = placeService.findById(placeId);
        List inputList =  place.getImages();
        RandomValues randomValues = new RandomValues();
        return randomValues.outputList(numberOfImages, inputList);
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

    @Override
    public void setListImageId(java.awt.List images) {

    }
}
