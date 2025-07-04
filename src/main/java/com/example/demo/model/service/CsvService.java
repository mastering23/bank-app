package com.example.demo.model.service;

import com.example.demo.model.UserRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CsvService {

    public List<UserRecord> loadUserRecords() {
        List<UserRecord> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource("data-file.csv").getInputStream()))) {

            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1);
//                if (fields.length < 6) continue;

                UserRecord user = new UserRecord();
                user.setUserId(Integer.parseInt(fields[0].trim()));
                user.setFullName(fields[1].trim());
                user.setSsnPlaceholder(fields[5].trim());
                users.add(user);

            }
        } catch (Exception e) {
            log.error("Failed to load CSV", e);
        }

        return users;
    }
}
