package com.unzilemedet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    @NotBlank(message = "Lütfen isminizi doldurunuz")
    @Size(min=3,max=20,message = "Kullanıcı adı en az 3 en fazla 20 karakter olabilir.")
    private String name;
    @Email
    @NotBlank(message = "Lütfen mailinizi giriniz")
    private String email;
    @NotBlank(message = "lütfen adresinizi doldurunuz")
    @Size(min=3,max=20,message = "Kullanıcı adı en az 3 en fazla 20 karakter olabilir.")
    private String address;
    @NotBlank(message = "Lütfen şifrenizi giriniz")
    @Size(min = 8, max = 64)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$"
            ,message = "Şifreniz en az büyük harf , küçük harf , bir sayı ve özel karakterden oluşmalıdır")

    private String password;

    private String repassword;
    @NotBlank(message = "Lütfen kart bilgilerinizi giriniz")
    @Size(min=3,max=20,message = "Kullanıcı adı en az 3 en fazla 20 karakter olabilir.")
    private String cardDetails;

    @Builder.Default
    private Double balance=0.0;

}
