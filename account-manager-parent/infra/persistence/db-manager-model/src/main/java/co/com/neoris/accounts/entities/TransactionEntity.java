package co.com.neoris.accounts.entities;


import co.com.neoris.accounts.domain.TranactionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.OffsetDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Column(name = "transaction_date")
    private OffsetDateTime transactionDate;

    @Column(name = "client_id_number")
    private String clientIdNumber;

    @Enumerated(EnumType.STRING)
    private TranactionTypeEnum transactionType;

    @Column(name = "value")
    private Double value;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "aud_created_At")
    private OffsetDateTime audCreatedAt;

    @Column(name = "aud_updated_At")
    private OffsetDateTime audUpdatedAt;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity account;
}
