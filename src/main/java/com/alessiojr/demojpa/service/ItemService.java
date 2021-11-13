package com.alessiojr.demojpa.service;

import com.alessiojr.demojpa.domain.Item;
import com.alessiojr.demojpa.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final Logger log = LoggerFactory.getLogger(ItemService.class);

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllList(){
        log.debug("Request to get All Item");
        return itemRepository.findAll();
    }

    public Optional<Item> findOne(Long id) {
        log.debug("Request to get Item : {}", id);
        return itemRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Item : {}", id);
        itemRepository.deleteById(id);
    }

    public Item save(Item item) {
        log.debug("Request to save Item : {}", item);
        item = itemRepository.save(item);
        return item;
    }

    public List<Item> saveAll(List<Item> itens) {
        log.debug("Request to save Item : {}", itens);
        itens = itemRepository.saveAll(itens);
        return itens;
    }
}
