package com.urbondo.announcement.api.service;

import com.urbondo.announcement.api.controller.AddRequestDto;
import com.urbondo.announcement.api.controller.UpdateRequestDto;
import com.urbondo.announcement.api.repositoy.AnnouncementDao;

public interface AnnouncementService {
    AnnouncementDao findById(String id);

    AnnouncementDao add(AddRequestDto requestDTO);

    AnnouncementDao update(UpdateRequestDto requestDTO);

    void deleteById(String id);
}
