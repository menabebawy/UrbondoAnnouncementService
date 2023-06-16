package com.urbondo.app.annoucement.repositoy;

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
    public Optional<AnnouncementDao> findById(String id) {
        AnnouncementDao announcementDAO = dynamoDBMapper.load(AnnouncementDao.class, id);

        if (announcementDAO == null) {
            return Optional.empty();
        }

        return Optional.of(announcementDAO);
    }

    @Override
    public AnnouncementDao save(AnnouncementDao announcementDAO) {
        dynamoDBMapper.save(announcementDAO);
        return announcementDAO;
    }

    @Override
    public void delete(AnnouncementDao announcementDAO) {
        dynamoDBMapper.delete(announcementDAO);
    }
}
