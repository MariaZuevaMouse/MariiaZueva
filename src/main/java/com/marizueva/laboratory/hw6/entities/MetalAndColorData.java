package com.marizueva.laboratory.hw6.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MetalAndColorData {
    @JsonProperty("summary")
    private String[] summary;

    @JsonProperty("elements")
    private String[] elements;

    @JsonProperty("color")
    private String color;

    @JsonProperty("metals")
    private String metal;

    @JsonProperty("vegetables")
    private String[] vegetables;
}
