package com.urbondo.announcement.api.service;

import com.urbondo.announcement.api.controller.AddRequestDTO;
import com.urbondo.announcement.api.controller.AnnouncementDTO;
import com.urbondo.announcement.api.controller.UpdateRequestDTO;

public interface AnnouncementService {
    AnnouncementDTO findById(String id);

    AnnouncementDTO add(AddRequestDTO requestDTO);

    AnnouncementDTO update(UpdateRequestDTO requestDTO);

    void deleteById(String id);
}
