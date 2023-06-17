package com.urbondo.announcement.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.urbondo.category.api.controller.AddCategoryRequestDto;
import com.urbondo.category.api.controller.CategoryController;
import com.urbondo.category.api.repository.CategoryDao;
import com.urbondo.category.api.service.CategoryService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CategoryController.class)
class CategoryControllerTests {
    private static final String TITLE = "Owner";
    private final String BASE_URL = "/category";
    private final String ID = "4bcdc561-6df2-41cc-996f-9de2b3af31bd";
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CategoryService categoryService;

    private static Stream<AddCategoryRequestDto> provideStreamOfAddRequests() {
        return Stream.of(new AddCategoryRequestDto(""),
                new AddCategoryRequestDto(null));
    }

    @Test
    void whenGetCategory_givenNotFoundId_thenNotFoundResource() throws Exception {
        when(categoryService.findById(ID)).thenThrow(new ResourceNotFoundException());

        mockMvc.perform(get(BASE_URL + "/" + ID).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenGetCategory_givenFoundId_ThenCorrect() throws Exception {
        when(categoryService.findById(ID)).thenReturn(categoryDAO());

        mockMvc.perform(get(BASE_URL + "/" + ID).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", Matchers.is(categoryDAO().getTitle())));
    }

    @ParameterizedTest
    @MethodSource("provideStreamOfAddRequests")
    void whenPostCategory_givenInvalidRequest_thenBadRequest(AddCategoryRequestDto requestDTO) throws Exception {
        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenPostCategory_givenValidRequest_thenCorrect() throws Exception {
        String title = "Building";
        AddCategoryRequestDto requestDTO = new AddCategoryRequestDto(title);

        when(categoryService.add(title)).thenReturn(new CategoryDao(ID, title));

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", Matchers.is(title)));
    }

    private CategoryDao categoryDAO() {
        return new CategoryDao(ID, TITLE);
    }
}
