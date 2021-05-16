package com.vimarsh.controller;

import com.vimarsh.dto.Dto;
import com.vimarsh.model.Modal;
import com.vimarsh.service.VimarshService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/deliveries")
public class Controller {
    @Autowired
    VimarshService deliveryService;

    @PostMapping(path = "")
    public ResponseEntity<Long> createOrUpdateDelivery(@RequestBody Dto deliveryDto) {
        log.info("Controller: createOrUpdateDelivery");
        Modal delivery = deliveryService.saveOrUpdate(deliveryDto);
        return new ResponseEntity<>(delivery.getId(), HttpStatus.OK);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Dto>> getDeliveries() {
        log.info("Controller: getDeliveries");
        List<Dto> deliveries = deliveryService.findAll();
        return new ResponseEntity<>(deliveries, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Dto> getDelivery(@PathVariable Long id) {
        log.info("Controller: getDelivery");
        Dto delivery = deliveryService.findById(id);
        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }
}