package com.urbondo.announcement.api.repositoy;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.urbondo.announcement.api.controller.AnnouncementDTO;

@DynamoDBTable(tableName = "urbondo-announcement")
public final class AnnouncementDAO {
    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute
    private String title;

    @DynamoDBAttribute
    private String body;

    @DynamoDBAttribute
    private String categoryId;

    @DynamoDBAttribute
    private String categoryTitle;

    @DynamoDBAttribute
    private String userId;

    AnnouncementDAO() {
    }

    public AnnouncementDAO(String id,
                           String title,
                           String body,
                           String categoryId,
                           String categoryTitle,
                           String userId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AnnouncementDTO transferTo() {
        return new AnnouncementDTO(id, title, body, categoryId, categoryTitle, userId);
    }
}
