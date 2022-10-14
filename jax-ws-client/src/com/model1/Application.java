package com.model1;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherService service=new WeatherServiceImplService().getWeatherServiceImplPort();
		WeatherWrapper weatherList=service.getWeatherByState("Mumbai");
		weatherList.getList().forEach(System.out::println);
	}

}
