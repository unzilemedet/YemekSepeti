package com.unzilemedet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    ERROR_PASSWORD(2004,"Girmiş olduğunuz şifreler uyuşmamaktadır", HttpStatus.BAD_REQUEST),
    INTERNATIONAL_ERROR(5100,"Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_USERNAME(2005,"Bu kullanıcı adı daha önce kayıt edilmiştir. Lütfen farklı bir kullanıcı adı giriniz.", HttpStatus.BAD_REQUEST),
    BAD_REQUEST(4000,"Geçersiz istek ya da parametre", HttpStatus.BAD_REQUEST),

    ERROR_INVALID_TOKEN(3000,"Geçersiz token bilgisi", HttpStatus.UNAUTHORIZED),

    LOGIN_ERROR(4100, "Kullanıcı adı veya şifre hatalı.", HttpStatus.BAD_REQUEST) ,
    PASSWORD_ERROR(4200,"Geçersiz istek ya da parametre", HttpStatus.BAD_REQUEST),

    USERNAME_DUPLICATE(4300, "Böyle bir kullanıcı bulunamadı", HttpStatus.BAD_REQUEST),

    USER_NOT_FOUND(4400, "Böyle bir kullanıcı bulunamadı.", HttpStatus.NOT_FOUND),
    ACTIVATE_CODE_ERROR(4500, "Aktivasyon kod hatası", HttpStatus.BAD_REQUEST),
    NOT_ACTIVATE_ERROR(4501, "Aktivasyon ilemini yapınız.Kullanıcı aktif değil.", HttpStatus.BAD_REQUEST),
    ERROR(9000, "Beklenmeyen bir hata oluştur. Lütfen tekrar deneyiniz.", HttpStatus.INTERNAL_SERVER_ERROR);
    int code;
    String message;
    HttpStatus httpStatus;

}
