/*
 * TestModelRepository TestModelRepository.java.
 * 
 * Copyright (c) 2018 OptimIT d.o.o.. All rights reserved.
 */
package com.example.application.views.helloworld;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestModelRepository extends JpaRepository<TestModel, Long> {
}
