package com.training.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.training.ifaces.WeatherService;
import com.training.model.Weather;
import com.training.model.WeatherWrapper;
@WebService(endpointInterface ="com.training.ifaces.WeatherService")
public class WeatherServiceImpl implements WeatherService {

	@Override
	@WebResult(name="current weather")
	public Weather getWeatherByCity(@WebParam(name="cityName") String cityName) {
		Weather weather=new Weather(cityName,32,21,60);
		if(cityName.equals("Goa")) {
			weather=new Weather(cityName,44,27,34);
			
		}
		return weather;
	}

	@Override
	@WebMethod
	public WeatherWrapper getWeatherByState(String stateName) {
		List<Weather> list=new ArrayList<Weather>();
		list.add(new Weather("Mumbai",32,21,60));
		list.add(new Weather("Ranchi",32,21,60));
		list.add(new Weather("Sam",32,21,60));
		
		WeatherWrapper obj=new WeatherWrapper(list);
		return obj;
	}

}
