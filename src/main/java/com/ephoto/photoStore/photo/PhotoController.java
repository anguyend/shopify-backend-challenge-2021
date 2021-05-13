package com.ephoto.photoStore.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/")
public class PhotoController {

    final
    PhotoList photoList;

    public PhotoController(PhotoList photoList) {
        this.photoList = photoList;
    }

    @GetMapping
    ModelAndView index() {
        return new ModelAndView("index", Map.of("items", this.photoList.getAll()));

    }
}
