package com.unzilemedet.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "Lütfen bir ürün ismi giriniz.")
    private String name;

    private String category;
    @NotNull(message = "Lütfen ürün fiyat bilgilerini giriniz.")
    private double cost;

    private Long restaurantId;





}
