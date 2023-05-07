package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class ImageService {

    private final Reader reader;
    private final RandomValues randomValues;
    private List imagesList;

    public ImageService(Reader reader, RandomValues randomValues) {
        this.reader = reader;
        this.randomValues = randomValues;
    }

    public Image findImageById(long id) {
        Image image = (Image) reader.getObjectById(Image.class, id);
        return image;
    }

    public double getImageIds(List imagesList) {
        double imageId = (double) randomValues.randomObjectFromList(imagesList);
        return imageId;
    }

    public Image getRandomImage(List inputImagesList) {
        Image image = (Image) randomValues.randomObjectFromList(inputImagesList);
        return image;
    }

    public Image randomImageFromIdList(List imagesIdList) {
        double imageId = (double) randomValues.randomObjectFromList(imagesIdList);
        return findImageById(Double.valueOf(imageId).longValue());
    }
    public List getImages(){
        return imagesList = reader.getList(Image.class);
    }
}