package com.urbondo.app.annoucement.controller;

import com.urbondo.app.annoucement.repositoy.AnnouncementDao;
import com.urbondo.app.annoucement.service.AnnouncementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    AnnouncementDao fetchById(@PathVariable @Valid String id) {
        return announcementService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    AnnouncementDao addAnnouncement(@RequestBody @Valid AddRequestDto requestDTO) {
        return announcementService.add(requestDTO);
    }

    @PutMapping
    @ResponseStatus(OK)
    AnnouncementDao update(@RequestBody @Valid UpdateRequestDto requestDTO) {
        return announcementService.update(requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    void deleteById(@PathVariable @Valid String id) {
        announcementService.deleteById(id);
    }
}

