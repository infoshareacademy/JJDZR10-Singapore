package com.singapore.TripPlaner.Service;

import java.util.List;

public interface IOpinions {
    List<Long> getOpinions();
    double getRate();
    void setRate(double d);
}
