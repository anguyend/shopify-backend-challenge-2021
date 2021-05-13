package com.ephoto.photoStore.photo;

import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<PhotoItemEntity, String> {
}
