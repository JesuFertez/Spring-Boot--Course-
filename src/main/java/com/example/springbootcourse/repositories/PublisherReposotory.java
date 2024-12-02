package com.example.springbootcourse.repositories;

import com.example.springbootcourse.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherReposotory extends CrudRepository<Publisher, Long> {
}
