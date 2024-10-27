package com.ai.chatmodel.api;

public record WeatherRequest(
        String location,
        Unit unit)
{}
