package com.urbondo.announcement.api.service;

import com.urbondo.announcement.api.controller.AddRequestDTO;
import com.urbondo.announcement.api.controller.UpdateRequestDTO;
import com.urbondo.announcement.api.repositoy.AnnouncementDAO;

public interface AnnouncementService {
    AnnouncementDAO findById(String id);

    AnnouncementDAO add(AddRequestDTO requestDTO);

    AnnouncementDAO update(UpdateRequestDTO requestDTO);

    void deleteById(String id);
}
