package com.ai.chatmodel.config;

import com.ai.chatmodel.api.WeatherRequest;
import com.ai.chatmodel.api.WeatherResponse;
import com.ai.chatmodel.service.WeatherServiceMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class AIConfig {

    @Bean
    @Description("Get the weather in location")
    public Function<WeatherRequest, WeatherResponse> currentWeather() {
        return new WeatherServiceMock();
    }

    // Another way to register a function is to create a FunctionCallbackWrapper like this:
    //@Bean
    //public FunctionCallback weatherFunctionInfo() {
    //
    //    return FunctionCallbackWrapper.builder(new MockWeatherService())
    //            .withName("CurrentWeather") // (1) function name
    //            .withDescription("Get the weather in location") // (2) function description
    //            .build();
    //}
}
