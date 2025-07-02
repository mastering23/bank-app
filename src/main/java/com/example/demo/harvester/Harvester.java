package com.example.demo.harvester;
import com.example.demo.model.ClientResponse;
import com.example.demo.model.DataItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class Harvester {

    public List<DataItem> harvestData() throws IOException {
        Resource resource = new ClassPathResource("client-response.json");

        ObjectMapper mapper = new ObjectMapper();
        ClientResponse response = mapper.readValue(resource.getInputStream(), ClientResponse.class);

        if(response.getStatus().equalsIgnoreCase("success")) {
            log.info("successfully harvested the data");
            return response.getData();

        } else {
            log.error("Something went wrong with harvested");
        }

        return null;
    }
}