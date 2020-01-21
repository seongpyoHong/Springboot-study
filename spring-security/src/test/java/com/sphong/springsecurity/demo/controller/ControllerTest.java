package com.sphong.springsecurity.demo.controller;

import com.sphong.springsecurity.demo.domain.Account;
import com.sphong.springsecurity.demo.dto.AccountRequestDto;
import com.sphong.springsecurity.demo.service.AccountService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private AccountService accountService;

    private AccountRequestDto account;
    List<GrantedAuthority> authorities = new ArrayList<>();
    @BeforeEach
    public void setUp() {
        authorities.add(new SimpleGrantedAuthority("USER"));
        account = AccountRequestDto.builder().email("test@email.com").password("password").build();
        accountService.save(account);
    }

    @AfterEach
    public void tearDown() {
        authorities.clear();
    }

    @Test
    @WithAnonymousUser
    @WithMockUser(username = "test@email.com", roles = "USER")
    public void 모든_유저에게_home_접속_허용 () throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithAnonymousUser
    public void 인증되지_않은_사용자_hello_접속_차단 () throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"))
                .andDo(print());
    }
    @Test
    @WithMockUser(username = "test@email.com", roles = "USER")
    public void 인증사용자_hello_접속_허용 () throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
