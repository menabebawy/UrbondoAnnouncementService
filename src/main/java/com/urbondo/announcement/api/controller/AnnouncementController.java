package com.urbondo.announcement.api.controller;

import com.urbondo.announcement.api.service.AnnouncementService;
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
    AnnouncementDTO fetchById(@PathVariable @Valid String id) {
        return announcementService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    AnnouncementDTO addAnnouncement(@RequestBody @Valid AddRequestDTO requestDTO) {
        return announcementService.add(requestDTO);
    }

    @PutMapping
    @ResponseStatus(OK)
    AnnouncementDTO update(@RequestBody @Valid UpdateRequestDTO requestDTO) {
        return announcementService.update(requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    void deleteById(@PathVariable @Valid String id) {
        announcementService.deleteById(id);
    }
}

