package com.urbondo.app.annoucement.service;


import com.urbondo.app.annoucement.controller.AddRequestDto;
import com.urbondo.app.annoucement.controller.UpdateRequestDto;
import com.urbondo.app.annoucement.repositoy.AnnouncementDao;

public interface AnnouncementService {
    AnnouncementDao findById(String id);

    AnnouncementDao add(AddRequestDto requestDTO);

    AnnouncementDao update(UpdateRequestDto requestDTO);

    void deleteById(String id);
}
