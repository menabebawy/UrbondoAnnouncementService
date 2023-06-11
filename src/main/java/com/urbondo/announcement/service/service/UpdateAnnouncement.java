package com.urbondo.announcement.service.service;

public record UpdateAnnouncement(String id,
                                 String title,
                                 String body,
                                 String categoryId,
                                 String categoryTitle) {}
