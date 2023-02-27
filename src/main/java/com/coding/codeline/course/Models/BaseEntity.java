package com.coding.codeline.course.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {

    @CreatedDate
    Date createdDate;

    @UpdateTimestamp
    Date updatedDate;

    Boolean isActive;
}
