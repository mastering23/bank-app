package com.example.demo;

import com.example.demo.harvester.Harvester;
import com.example.demo.model.DataItem;
import com.example.demo.model.dto.MergedExpenseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.service.DataMergeService;


import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RestService {

    @GetMapping("/greetings")
    public String greetings() {
        return "Hello World";
    }

    @GetMapping("/testing")
    public String testing() {
        return "testing is working";
    }

    @Autowired
    Harvester harvester;

    @GetMapping("/data")
    public List<DataItem> getData() throws IOException {
        return harvester.harvestData();
    }


    @Autowired
    private DataMergeService dataMergeService;


    @GetMapping("/expenses/merged")
    public List<MergedExpenseDTO> getMerged() throws IOException {
        return dataMergeService.getMergedExpenses();
    }

}
