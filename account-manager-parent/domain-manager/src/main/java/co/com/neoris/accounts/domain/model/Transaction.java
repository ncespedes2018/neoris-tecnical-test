package co.com.neoris.accounts.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {

    private Long id;

    private OffsetDateTime transactionDate;

    private String transactionType;

    private Double value;

    private Double balance;

    private OffsetDateTime audCreatedAt;

    private OffsetDateTime audUpdatedAt;

    private String accountNumber;

    private String clientIdNumber;
}
