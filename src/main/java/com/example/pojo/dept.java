package com.example.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;



@Entity    //这个jpa注解必须加
@Data
@ToString
public class dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
   String name;

   Timestamp create_time;
   Timestamp update_time;



}
