package com.marizueva.laboratory.hw6.dataprovider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marizueva.laboratory.hw6.entities.MetalAndColorData;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DataProviders {
    private static final String dataFile = "src/test/resources/jdi/JDI_ex8_metalsColorsDataSet.json";
    private static ObjectMapper mapper = new ObjectMapper();
    private static Map<String, MetalAndColorData> dataMap = new HashMap<>();

    @DataProvider(name = "metalAndColorDataSet")
    public static Object[][] metalAndColorSetOfData() {
        getData();

        int i = 0;
        Object[][] data = new Object[dataMap.size()][1];
        for (Map.Entry<String, MetalAndColorData> entry : dataMap.entrySet()) {
            data[i][0] = entry.getValue();
            i++;
        }

        return data;
    }

    private static void getData() {
        try {
            byte[] mapData = Files.readAllBytes(Paths.get(dataFile));
            dataMap = mapper.readValue(mapData, new TypeReference<HashMap<String, MetalAndColorData>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
