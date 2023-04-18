package com.unzilemedet.entity;
import com.unzilemedet.utility.enums.EStatus;
import com.unzilemedet.utility.enums.EUserType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblcustomers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String address;
    private String phoneNumber;
    private String password;
    private String repassword;
    private String cardDetails;

    @Builder.Default
    private Double balance=0.0;
    private String activationCode;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.PENDING;

}
