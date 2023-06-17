package com.urbondo.announcement.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.urbondo.announcement.api.controller.AddRequestDto;
import com.urbondo.announcement.api.controller.AnnouncementController;
import com.urbondo.announcement.api.controller.UpdateRequestDto;
import com.urbondo.announcement.api.repositoy.AnnouncementDao;
import com.urbondo.announcement.api.service.AnnouncementService;
import com.urbondo.lib.ResourceNotFoundException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AnnouncementController.class)
class AnnouncementControllerTests {
    private final static String BASE_URL = "/announcement";
    private final static String ID = "4bcdc561-6df2-41cc-996f-9de2b3af31bd";
    private final String CATEGORY_ID = "4alydc561-6mf2-41cc-996f-9ce2b3af31vk";
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    MockMvc mockMvc;
    @MockBean
    AnnouncementService announcementService;

    private static Stream<AddRequestDto> provideStreamOfInvalidAddRequestDTO() {
        return Stream.of(new AddRequestDto("", "body", "12", "123"),
                new AddRequestDto("title", null, "12", "123"),
                new AddRequestDto("title", "body", null, "123"),
                new AddRequestDto("title", "body", "12", null));
    }

    private static Stream<UpdateRequestDto> provideStreamOfInvalidUpdateRequestDTO() {
        return Stream.of(new UpdateRequestDto("", "title", "body", "12"),
                new UpdateRequestDto(ID, "", "body", "12"),
                new UpdateRequestDto(ID, "title", "body", ""),
                new UpdateRequestDto(ID, "title", null, "12"));
    }

    @Test
    void whenGetAnnouncement_givenNotFoundId_thenNotFound() throws Exception {
        when(announcementService.findById(ID)).thenThrow(new ResourceNotFoundException());

        mockMvc.perform(get(BASE_URL + "/" + ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenGetAnnouncement_givenFoundId_thenGetAnnouncement() throws Exception {
        when(announcementService.findById(ID)).thenReturn(announcementDAO());

        mockMvc.perform(get(BASE_URL + "/" + ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(ID)))
                .andExpect(jsonPath("$.title", Matchers.is(announcementDAO().getTitle())))
                .andExpect(jsonPath("$.body", Matchers.is(announcementDAO().getBody())))
                .andExpect(jsonPath("$.categoryId", Matchers.is(announcementDAO().getCategoryId())));
    }

    @ParameterizedTest
    @MethodSource("provideStreamOfInvalidAddRequestDTO")
    void whenPostAnnouncement_givenInvalidRequest_thenBadRequest(AddRequestDto addRequestDTO) throws Exception {
        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addRequestDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenPostAnnouncement_givenValidRequest_thenCorrect() throws Exception {
        AddRequestDto requestDTO = new AddRequestDto("Title", "Body", CATEGORY_ID, "123");

        when(announcementService.add(any())).thenReturn(announcementDAO());

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", Matchers.is(requestDTO.getTitle())))
                .andExpect(jsonPath("$.categoryTitle", Matchers.is(announcementDAO().getCategoryTitle())));
    }

    @ParameterizedTest
    @MethodSource("provideStreamOfInvalidUpdateRequestDTO")
    void whenPutAnnouncement_givenInvalidRequest_thenBadRequest(UpdateRequestDto requestDTO) throws Exception {
        mockMvc.perform(put(BASE_URL).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenPutAnnouncement_givenValidRequest_thenCorrect() throws Exception {
        String newTitle = "New Title";
        UpdateRequestDto requestDTO = new UpdateRequestDto(ID,
                newTitle,
                announcementDAO().getBody(),
                announcementDAO().getCategoryId());

        AnnouncementDao updatedDAO = new AnnouncementDao(ID,
                newTitle,
                announcementDAO().getBody(),
                announcementDAO().getCategoryId(),
                announcementDAO().getCategoryTitle(),
                announcementDAO().getUserId());

        when(announcementService.update(any())).thenReturn(updatedDAO);

        mockMvc.perform(put(BASE_URL).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", Matchers.is(newTitle)));
    }

    @Test
    void whenDeleteAnnouncement_givenFoundId_thenNoContent() throws Exception {
        mockMvc.perform(delete(BASE_URL + "/" + ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    private AnnouncementDao announcementDAO() {
        return new AnnouncementDao(ID, "Title", "Body", CATEGORY_ID, "Category Title", "123");
    }
}
