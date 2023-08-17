package com.app.controller;

import com.app.dto.PostDeliveryStatusResponse;
import com.app.model.History;
import com.app.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/history")
@RestController
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;
    @GetMapping("/all/{id}")
    public ResponseEntity<List<History>> getAllById(@PathVariable Long id){
        return ResponseEntity.ok(historyService.getAllById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDeliveryStatusResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(historyService.getById(id));
    }
}
