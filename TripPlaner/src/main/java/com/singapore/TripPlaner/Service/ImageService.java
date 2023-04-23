package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class ImageService {
    private final Image image;
    private List imagesList;
    private final Reader reader;
    private final Writer writer;

    public ImageService(Image image, Reader reader, Writer writer) {
        this.image = image;
        this.reader = reader;
        this.writer = writer;
    }

    private String findImageById (long id){
        Image image =  (Image) reader.getObjectById(Image.class, id);
        return image.getUrl();
    }

    public Places getPlaceByImageId(double imageId) throws NullPointerException {
        List<Places> places = reader.getAllPlaces(Places.class);
        Places placeByImageId = null;
        for (long i = 0; i < places.size(); i++) {
            placeByImageId = places.get((int) i);
            if (placeByImageId.getImages().contains(imageId)) {
                break;
            }
        }
        return placeByImageId;
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
