package com.ssafit.ccachi.user.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateUserRequestDto {

    @Override
    public String toString() {
        return "CreateUserRequestDto{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    //    @NonNull
    private String userId;
//    @NonNull
    private String password;
//    @NonNull
    private String name;
//    @NonNull
    private String email;
//    @NonNull
    private String phone;

}
