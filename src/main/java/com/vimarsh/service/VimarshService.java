package com.vimarsh.service;

import com.vimarsh.dto.Dto;
import com.vimarsh.model.Modal;
import com.vimarsh.repository.Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Slf4j
@Service
public class VimarshService {
    @Autowired
    Repo Repo;

    @Cacheable("deliveries")
    public List<Dto> findAll(){
        log.info("VimarshService: findAll");
        List<Modal> deliveries = Repo.findAll();
        List<Dto> Dtos = new ArrayList<>();
        for (Modal Modal:deliveries){
            Dto Dto = new Dto();
            copyProperties(Modal, Dto);
            Dtos.add(Dto);
        }
        return Dtos;
    }

    @Cacheable("Modal")
    public Dto findById(Long id){
        log.info("VimarshService: findById");
        Modal Modal = Repo.findById(id).orElse(null);
        Dto Dto = new Dto();
        copyProperties(Modal,Dto);
        return Dto;
    }

    @Caching(evict = {
        @CacheEvict(value="Modal", allEntries=true),
        @CacheEvict(value="deliveries", allEntries=true)})
public Modal saveOrUpdate(Dto dto){
    log.info("DeliveryService: saveOrUpdate, {}", dto.getPickupName());
    Modal mod = Modal.builder()
            .pickupName(dto.getPickupName())
            .build();
    if(dto.getId()!=null){
        mod.setId(dto.getId());
    }
    return Repo.save(mod);
}
}