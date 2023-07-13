package com.singapore.TripPlaner.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class BaseLogger {
    protected final Logger logger;

    public BaseLogger() {
        logger = LoggerFactory.getLogger(getClass());
    }
}
