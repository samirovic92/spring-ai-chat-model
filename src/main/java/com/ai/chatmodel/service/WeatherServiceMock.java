package com.ai.chatmodel.service;

import com.ai.chatmodel.api.Unit;
import com.ai.chatmodel.api.WeatherRequest;
import com.ai.chatmodel.api.WeatherResponse;

import java.util.Random;
import java.util.function.Function;

public class WeatherServiceMock implements Function<WeatherRequest, WeatherResponse> {

    @Override
    public WeatherResponse apply(WeatherRequest weatherRequest) {
        Random random = new Random();
        return new WeatherResponse(random.nextInt(41), Unit.C);
    }
}
