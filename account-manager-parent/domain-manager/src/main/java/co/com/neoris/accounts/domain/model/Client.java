package co.com.neoris.accounts.domain.model;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
