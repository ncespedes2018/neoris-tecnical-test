package co.com.neoris.accounts.domain.model;

import lombok.*;

import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    private Long id;

    private String clientIdNumber;

    private String password;

    private String accountNumber;

    private String accountType;

    private Double initialBalance;

    private Boolean status;

    private OffsetDateTime audCreatedAt;

    private OffsetDateTime audUpdatedAt;
}
