package com.arnoldgalovics.bookshelf.service;

import static java.util.stream.Collectors.toList;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arnoldgalovics.bookshelf.repository.dao.AuthorRepository;
import com.arnoldgalovics.bookshelf.service.domain.AuthorView;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Collection<AuthorView> getAuthors() {
        return authorRepository.findAll().stream().map(AuthorView::new).collect(toList());
    }
}
