package com.urbondo.category.api.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
class CategoryRepositoryImpl implements CategoryRepository {
    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    CategoryRepositoryImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Optional<CategoryDAO> findById(String id) {
        CategoryDAO categoryDAO = dynamoDBMapper.load(CategoryDAO.class, id);
        if (categoryDAO == null) {
            return Optional.empty();
        }
        return Optional.of(dynamoDBMapper.load(CategoryDAO.class, id));
    }

    @Override
    public Optional<CategoryDAO> findByTitle(String title) {
        Map<String, AttributeValue> attributesValues = new HashMap<>();
        attributesValues.put(":title", new AttributeValue().withS(title));

        Map<String, String> attributesNames = new HashMap<>();
        attributesNames.put("#title", "title");

        DynamoDBQueryExpression<CategoryDAO> queryExpression = new DynamoDBQueryExpression<CategoryDAO>().withIndexName(
                        "title-index")
                .withKeyConditionExpression("#title = :title")
                .withExpressionAttributeNames(attributesNames)
                .withExpressionAttributeValues(attributesValues)
                .withConsistentRead(false);

        return dynamoDBMapper.query(CategoryDAO.class, queryExpression).stream().findFirst();
    }

    @Override
    public CategoryDAO save(CategoryDAO categoryDAO) {
        dynamoDBMapper.save(categoryDAO);
        return categoryDAO;
    }
}
