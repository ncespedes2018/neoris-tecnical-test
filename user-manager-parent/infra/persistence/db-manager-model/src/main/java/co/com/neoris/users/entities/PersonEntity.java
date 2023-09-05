package co.com.neoris.users.entities;


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
@Table(name = "person")
public class PersonEntity {
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "aud_created_At")
    private OffsetDateTime audCreatedAt;

    @Column(name = "aud_updated_At")
    private OffsetDateTime audUpdatedAt;
}
