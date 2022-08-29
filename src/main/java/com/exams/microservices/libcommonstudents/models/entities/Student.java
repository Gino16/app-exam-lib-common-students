package com.exams.microservices.libcommonstudents.models.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String lastname;
  private String email;

  @Column(name = "create_at")
  @Temporal(TemporalType.DATE)
  private Date createAt;

  @PrePersist
  public void prePersist() {
    this.createAt = new Date();
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (!(o instanceof Student)) return false;

    Student student = (Student) o;
    return this.id != null && this.id.equals(student.getId());
  }
}
