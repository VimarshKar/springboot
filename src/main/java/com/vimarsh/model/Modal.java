package com.vimarsh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Modal")
public class Modal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "darcl_name")
    private String pickupName;
    @Column(name = "darcl_address")
    private String pickupAddress;
    @Column(name = "darcl_datetime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date pickupDateTime;
    @Column(name = "darcl_contact_numbers")
    private String pickupContactNumbers;
    @Column(name = "darcl_comment")
    private String pickupComment;
}
