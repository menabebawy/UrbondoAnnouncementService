package com.urbondo.announcement.service.controller;

import com.urbondo.announcement.service.service.AnnouncementService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    AnnouncementDTO fetchById(@PathVariable @Valid final String id) {
        return AnnouncementDTO.transferBy(announcementService.findById(id));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    AddAnnouncementResponseDTO addAnnouncement(@RequestBody @Valid final AddAnnouncementRequestDTO requestDTO) {
        return new AddAnnouncementResponseDTO(announcementService.add(requestDTO.transferTo()));
    }

    @PutMapping
    @ResponseStatus(OK)
    AnnouncementDTO update(@RequestBody @Valid final UpdateAnnouncementRequestDTO requestDTO) {
        return AnnouncementDTO.transferBy(announcementService.update(requestDTO.transferTo()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    void deleteById(@PathVariable @Valid final String id) {
        announcementService.deleteById(id);
    }
}

