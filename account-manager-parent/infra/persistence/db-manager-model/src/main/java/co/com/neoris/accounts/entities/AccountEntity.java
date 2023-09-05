package co.com.neoris.accounts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "account")
public class AccountEntity {

    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Column(name = "client_id_number", nullable = false)
    private String clientIdNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "initial_balance")
    private Double initialBalance;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "aud_created_At")
    private OffsetDateTime audCreatedAt;

    @Column(name = "aud_updated_At")
    private OffsetDateTime audUpdatedAt;

}
