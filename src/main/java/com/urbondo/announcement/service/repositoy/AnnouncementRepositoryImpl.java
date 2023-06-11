package com.urbondo.announcement.service.repositoy;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class AnnouncementRepositoryImpl implements AnnouncementRepository {
    private final DynamoDBMapper dynamoDBMapper;

    public AnnouncementRepositoryImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Optional<AnnouncementDAO> findById(String id) {
        AnnouncementDAO announcementDAO = dynamoDBMapper.load(AnnouncementDAO.class, id);

        if (announcementDAO == null) {
            return Optional.empty();
        }

        return Optional.of(announcementDAO);
    }

    @Override
    public String add(AnnouncementDAO announcementDAO) {
        dynamoDBMapper.save(announcementDAO);
        return announcementDAO.getId();
    }

    @Override
    public AnnouncementDAO update(AnnouncementDAO announcementDAO) {
        dynamoDBMapper.save(announcementDAO);
        return announcementDAO;
    }

    @Override
    public void delete(AnnouncementDAO announcementDAO) {
        dynamoDBMapper.delete(announcementDAO);
    }
}
