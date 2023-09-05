package co.com.neoris.users.domain.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    private Long id;

    private String fullName;

    private String gender;

    private Integer age;

    private String idNumber;

    private String address;

    private String phone;

    private String password;

    private Boolean status;
}
