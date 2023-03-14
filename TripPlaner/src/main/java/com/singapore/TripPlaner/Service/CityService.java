package com.singapore.TripPlaner.Service;

//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class CityService extends Reader {
//    public void findAllCities() {
//        List<Persistent> city = getList(City.class);
//        for (Persistent listOfCity : city) {
//            City oParsed = (City) listOfCity;
//            System.out.println(oParsed);
//        }
//    }
//    public void showCityNameById(int index) {
//        List<City> city = getAllCities(City.class);
//        List<City> filteredList = filterListByCityIndex(index, city);
//        showOnlyNameOfCity(filteredList).forEach(System.out::println);
//    }
//
//
//    private List<City> filterListByCityIndex(int index, List<City> place) {
//        return place.stream().filter(p -> p.getId() == index).collect(Collectors.toList());
//    }
//    private List<String> showOnlyNameOfCity (List<City> list){
//        Function<City, String> onlyName = s->s.getName();
//        return list.stream().map(onlyName).collect(Collectors.toList());
//    }
//}