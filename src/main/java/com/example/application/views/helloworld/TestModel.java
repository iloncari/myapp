/*
 * TestModel TestModel.java.
 *
 * Copyright (c) 2018 OptimIT d.o.o.. All rights reserved.
 */
package com.example.application.views.helloworld;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TestModel {

  @Column(nullable = false)
  private final Date createDate;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  public String name;

  public int age;

  public TestModel() {
    this.createDate = new Date();
  }

  public TestModel(String name, int age) {
    this.name = name;
    this.age = age;
    this.createDate = new Date();
  }
}
