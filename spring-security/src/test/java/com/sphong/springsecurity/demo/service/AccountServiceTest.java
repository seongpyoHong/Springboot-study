package com.sphong.springsecurity.demo.service;

import com.sphong.springsecurity.demo.domain.Account;
import com.sphong.springsecurity.demo.domain.AccountRepository;
import com.sphong.springsecurity.demo.dto.AccountRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @AfterEach
    public void tearDown() {
        accountRepository.deleteAll();
    }

    @Test
    public void 입력한_비밀번호와_인코딩된_비밀번호가_일치한다() {
        //given
        String email = "test@mail.com";
        String password = "password";

        //when
        passwordEncoder.matches(password,passwordEncoder.encode(password));
    }

    @Test
    @WithMockUser(username = "test@email.com", roles = "USER")
    public void 회원가입() throws Exception {
        //given
        AccountRequestDto requestDto = AccountRequestDto.builder().email("test@mail.com").password("password").build();
        //when
        Account account = accountService.save(requestDto);
        //then
        List<Account> accountList = accountRepository.findAll();
        assertEquals("test@mail.com",accountList.get(0).getEmail());
    }

    //TODO: 로그인 테스트 추가하기
}