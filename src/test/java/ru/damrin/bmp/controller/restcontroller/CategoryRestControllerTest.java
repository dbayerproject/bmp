package ru.damrin.bmp.controller.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.damrin.bmp.dto.CategoryDTO;
import ru.damrin.bmp.exceptions.CategoryNotFoundException;
import ru.damrin.bmp.service.CategoryService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class CategoryRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryRestController categoryRestController;

    private JacksonTester<CategoryDTO> jsonCategory;

    @BeforeEach
    void setUp() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(categoryRestController).build();
    }

    final CategoryDTO testCategoryDto = new CategoryDTO(1, "Category", "The description of a category");

    @Test
    void testAllCategories() throws Exception {
        List<CategoryDTO> allCategories = Arrays.asList(testCategoryDto);

        given(categoryService.findAllDto()).willReturn(allCategories);

        mockMvc.perform(get("/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(testCategoryDto.getId())))
                .andExpect(jsonPath("$[0].name", is(testCategoryDto.getName())))
                .andExpect(jsonPath("$[0].description", is(testCategoryDto.getDescription())));
    }

    @Test
    void testOneCategory() throws Exception {
        given(categoryService.findOne(anyInt()))
                .willReturn(testCategoryDto);

        MockHttpServletResponse response = mockMvc.perform(
                        get("/categories/1")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonCategory.write(new CategoryDTO(1, "Category", "The description of a category")).getJson());
    }

    @Test
    void testOneCategoryFailure() throws Exception {
        given(categoryService.findOne(anyInt())).willThrow(CategoryNotFoundException.class);

        Assertions.assertThrows(CategoryNotFoundException.class, () -> categoryRestController.oneCategory(1));

        verify(categoryService).findOne(anyInt());
    }

    @Test
    void testNewCategory() throws Exception {
        given(categoryService.addCategory(any())).willReturn(testCategoryDto);

        mockMvc.perform(post("/categories").contentType(MediaType.APPLICATION_JSON).content(
                        jsonCategory.write(testCategoryDto).getJson()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(testCategoryDto.getId())))
                .andExpect(jsonPath("$.name", is(testCategoryDto.getName())))
                .andExpect(jsonPath("$.description", is(testCategoryDto.getDescription())));

    }

    @Test
    void testUpdateCategory() throws Exception {

        given(categoryService.updateCategory(anyInt(), any())).willReturn(testCategoryDto);

        mockMvc.perform(put("/categories/1").contentType(MediaType.APPLICATION_JSON).content(
                        jsonCategory.write(testCategoryDto).getJson()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testCategoryDto.getId())))
                .andExpect(jsonPath("$.name", is(testCategoryDto.getName())))
                .andExpect(jsonPath("$.description", is(testCategoryDto.getDescription())));
    }

    @Test
    void testDeleteCategory() throws Exception {
        mockMvc.perform(delete("/categories/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}