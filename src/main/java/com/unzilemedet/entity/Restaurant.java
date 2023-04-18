package com.unzilemedet.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "tblrestaurant")
public class
Restaurant  implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private double point;
    @NotBlank(message = "Lütfen restoran adres bilgilerini giriniz.")
    private String address;


    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> productId;

}
