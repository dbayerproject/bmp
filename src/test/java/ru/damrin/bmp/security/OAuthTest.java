package ru.damrin.bmp.security;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.damrin.bmp.controller.restcontroller.CategoryRestController;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OAuthTest {
    private static final String GOOGLE_TEST_EMAIL = "bmptestoauth@gmail.com";
    private static final String GOOGLE_TEST_PASS = "hfCskxWWridr3DKLQZfK";
    private static final String GOOGLE_CLIENT_ID = "1047401721972-naq4i8jl0su7iguvgam0bh5egi2vb9h0.apps.googleusercontent.com";
    private static final String GOOGLE_CLIENT_SECRET = "RIrYeCnwsFqj7gvcChTITY4g";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private CategoryRestController controller;

    @Test
    public void loginWindowAppearenceTest() throws Exception {
        this.mockMvc
                .perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void categoriesAuthenticatedAccessTest() throws Exception {
        this.mockMvc
                .perform(get("/categoties"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void emailAuthenticationTest() throws Exception {
        this.mockMvc
                .perform(formLogin().user("admin").password("admin"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

}