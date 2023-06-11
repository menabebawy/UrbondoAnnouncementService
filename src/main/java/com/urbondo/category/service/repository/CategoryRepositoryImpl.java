package com.urbondo.category.service.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
class CategoryRepositoryImpl implements CategoryRepository {
    private final DynamoDBMapper dynamoDBMapper;

    CategoryRepositoryImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Optional<CategoryDAO> findById(final String id) {
        CategoryDAO categoryDAO = dynamoDBMapper.load(CategoryDAO.class, id);
        if (categoryDAO == null) {
            return Optional.empty();
        }
        return Optional.of(dynamoDBMapper.load(CategoryDAO.class, id));
    }

    @Override
    public Optional<CategoryDAO> findByTitle(final String title) {
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
    public String add(CategoryDAO categoryDAO) {
        dynamoDBMapper.save(categoryDAO);
        return categoryDAO.getId();
    }
}
