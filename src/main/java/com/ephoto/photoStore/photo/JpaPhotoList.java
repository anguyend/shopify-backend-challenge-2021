package com.ephoto.photoStore.photo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class JpaPhotoList implements PhotoList {

    private final PhotoRepository photoRepository;

    public JpaPhotoList(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public List<PhotoItem> getAll() {
        return StreamSupport.stream(this.photoRepository.findAll().spliterator(), false)
                .map(entity -> {
                    PhotoItem item = new PhotoItem();
                    item.setTitle(entity.getTitle());
                    item.setPrice(entity.getPrice());

                    return item;
                })
                .collect(Collectors.toList());
    }
}
