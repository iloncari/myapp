/*
 * HelloWorldView HelloWorldView.java.
 *
 * Copyright (c) 2018 OptimIT d.o.o.. All rights reserved.
 */
package com.example.application.views.helloworld;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

  private final TextField name;
  private final Button sayHello;
  @Autowired
  private TestModelRepository re;

  public HelloWorldView() {
    addClassName("hello-world-view");
    name = new TextField("Your name");
    sayHello = new Button("Say hello");
    final Button b = new Button();
    b.setText("ispisi");
    b.addClickListener(e -> {
      re.findAll().forEach(tm -> Notification.show(tm.name + " " + tm.age));
    });
    add(name, sayHello);
    add(b);
    setVerticalComponentAlignment(Alignment.END, name, sayHello);
    sayHello.addClickListener(e -> {
      Notification.show("Hello " + name.getValue());
      final TestModel m = new TestModel(name.getValue() + LocalDateTime.now().getSecond(), LocalDate.now().getMonthValue());
      final TestModel saved = re.save(m);
      if (saved == null) {
        Notification.show("not saved");
      } else {
        Notification.show("saved");
      }
    });
  }

}
