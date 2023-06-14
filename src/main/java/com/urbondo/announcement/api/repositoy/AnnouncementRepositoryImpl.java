package com.urbondo.announcement.api.repositoy;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
class AnnouncementRepositoryImpl implements AnnouncementRepository {
    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
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
    public AnnouncementDAO save(AnnouncementDAO announcementDAO) {
        dynamoDBMapper.save(announcementDAO);
        return announcementDAO;
    }

    @Override
    public void delete(AnnouncementDAO announcementDAO) {
        dynamoDBMapper.delete(announcementDAO);
    }
}
