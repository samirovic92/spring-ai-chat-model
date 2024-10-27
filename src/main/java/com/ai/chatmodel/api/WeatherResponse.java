package com.ai.chatmodel.api;

public record WeatherResponse(
        double temp,
        Unit unit
) {
}
