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
}
