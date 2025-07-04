package com.example.demo.model.service;

import com.example.demo.model.dto.MergedExpenseDTO;
import com.example.demo.harvester.Harvester;
import com.example.demo.model.DataItem;
import com.example.demo.model.UserRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataMergeService {

    private final Harvester harvester;
    private final com.example.demo.model.service.CsvService csvService;

    public List<MergedExpenseDTO> getMergedExpenses() throws IOException {
        List<DataItem> expenses = harvester.harvestData().stream()
                .filter(item -> "Expense".equalsIgnoreCase(item.getCategory()))
                .collect(Collectors.toList());

        List<UserRecord> users = csvService.loadUserRecords();

        return expenses.stream()
                .map(expense -> {
                    UserRecord matchedUser = users.stream()
                            .filter(u -> u.getUserId() == expense.getId())
                            .findFirst()
                            .orElse(null);

                    if (matchedUser == null) return null;

                    MergedExpenseDTO dto = new MergedExpenseDTO();
                    dto.setId(expense.getId());
                    dto.setAmount(expense.getAmount());
                    dto.setCurrency(expense.getCurrency());
                    dto.setFullName(matchedUser.getFullName());
                    String ssn = matchedUser.getSsnPlaceholder();
                    dto.setSsnLast4(ssn.length() >=4 ? ssn.substring(ssn.length() - 4) : ssn);

                    return dto;
                })
                .filter(dto -> dto != null)
                .collect(Collectors.toList());
    }
}
