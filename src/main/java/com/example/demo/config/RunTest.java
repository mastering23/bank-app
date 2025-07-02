package com.example.demo.config;

import com.example.demo.harvester.Harvester;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("RUNNING HARVESTER");
        Harvester harvester = new Harvester();
        harvester.harvestData();


    }
}
