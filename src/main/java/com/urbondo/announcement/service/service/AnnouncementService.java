package com.urbondo.announcement.service.service;

import com.urbondo.announcement.service.dto.AddAnnouncementRequestDTO;
import com.urbondo.announcement.service.dto.AddAnnouncementResponseDTO;
import com.urbondo.announcement.service.dto.AnnouncementDTO;
import com.urbondo.announcement.service.dto.UpdateAnnouncementRequestDTO;

public interface AnnouncementService {
    AnnouncementDTO findById(final String id);

    AddAnnouncementResponseDTO add(final AddAnnouncementRequestDTO requestDTO);

    AnnouncementDTO update(final UpdateAnnouncementRequestDTO requestDTO);

    void deleteById(final String id);
}
