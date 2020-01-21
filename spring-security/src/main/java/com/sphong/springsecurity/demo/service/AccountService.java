package com.sphong.springsecurity.demo.service;

import com.sphong.springsecurity.demo.domain.Account;
import com.sphong.springsecurity.demo.domain.AccountRepository;
import com.sphong.springsecurity.demo.dto.AccountRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Account save(AccountRequestDto account) {
        System.out.println(account.getEmail());
        System.out.println(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(Account.builder()
                .email(account.getEmail())
                .password(passwordEncoder.encode(account.getPassword()))
                .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("not found!"));
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new User(account.getEmail(), account.getPassword(), authorities);
    }
}
