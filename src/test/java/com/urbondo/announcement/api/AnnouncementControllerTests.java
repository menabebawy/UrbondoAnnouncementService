package com.urbondo.announcement.api;

import com.urbondo.announcement.api.controller.AnnouncementController;
import com.urbondo.announcement.api.controller.AnnouncementDTO;
import com.urbondo.announcement.api.service.AnnouncementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AnnouncementController.class)
class AnnouncementControllerTests {
    private final static String BASE_URL = "/announcement";
    private final static String ID = "13";
    @Autowired
    MockMvc mockMvc;
    @MockBean
    AnnouncementService announcementService;

    @Test
    void whenGetAnnouncement_givenNotFoundId_thenNotFound() throws Exception {
        mockMvc.perform(get(BASE_URL + "/" + ID)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenGetAnnouncement_givenFoundId_thenGetAnnouncement() {

    }

    private AnnouncementDTO announcementDTO() {
        return new AnnouncementDTO(ID, "", "", "", "", "");
    }
}
