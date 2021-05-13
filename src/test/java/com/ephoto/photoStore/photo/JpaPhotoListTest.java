package com.ephoto.photoStore.photo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaPhotoList.class)
class JpaPhotoListTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    JpaPhotoList photoList;

    @Test
    void loadDataFromDataBase() {

        String expectedTitle = "Dachshund";
        PhotoItemEntity entity = new PhotoItemEntity();
        entity.setSku("d1");
        entity.setTitle(expectedTitle);
        entity.setPrice(BigDecimal.TEN);
        testEntityManager.persist(entity);

        List<PhotoItem> actualItems = this.photoList.getAll();

        assertThat(actualItems).extracting(PhotoItem::getTitle).contains(expectedTitle);

        assertThat(actualItems).extracting(PhotoItem::getPrice).contains(BigDecimal.TEN);
    }

}