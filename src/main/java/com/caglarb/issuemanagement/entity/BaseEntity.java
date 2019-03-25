package com.caglarb.issuemanagement.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data //Lombok'tan geliyor, getter ve setter yapmamıza gerek kalmıyor
@MappedSuperclass//JPA'dan gelen bütün tablolarda ortak olmasını sağlıyor.
// (devam)Diğer classlarda extend edilebilir hale geliyor.
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreateAt;
    @Column(name = "created_by", length = 50)
    private String CreatedBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date UpdatedAt;
    @Column(name = "updated_by", length = 50)
    private String UpdatedBy;
    @Column(name = "status")
    private Boolean status;


}
