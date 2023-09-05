package co.com.neoris.users.mappers;

import co.com.neoris.users.domain.model.Client;
import co.com.neoris.users.domain.model.Client.ClientBuilder;
import co.com.neoris.users.entities.ClientEntity;
import co.com.neoris.users.entities.ClientEntity.ClientEntityBuilder;
import co.com.neoris.users.entities.PersonEntity;
import co.com.neoris.users.entities.PersonEntity.PersonEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-05T06:48:55+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class IClientConverterImpl implements IClientConverter {

    @Override
    public Client fromEntityToModel(ClientEntity ClientEntity) {
        if ( ClientEntity == null ) {
            return null;
        }

        ClientBuilder client = Client.builder();

        String fullName = clientEntityPersonFullName( ClientEntity );
        if ( fullName != null ) {
            client.fullName( fullName );
        }
        String gender = clientEntityPersonGender( ClientEntity );
        if ( gender != null ) {
            client.gender( gender );
        }
        Integer age = clientEntityPersonAge( ClientEntity );
        if ( age != null ) {
            client.age( age );
        }
        String idNumber = clientEntityPersonIdNumber( ClientEntity );
        if ( idNumber != null ) {
            client.idNumber( idNumber );
        }
        String address = clientEntityPersonAddress( ClientEntity );
        if ( address != null ) {
            client.address( address );
        }
        String phone = clientEntityPersonPhone( ClientEntity );
        if ( phone != null ) {
            client.phone( phone );
        }
        if ( ClientEntity.getId() != null ) {
            client.id( ClientEntity.getId() );
        }
        if ( ClientEntity.getPassword() != null ) {
            client.password( ClientEntity.getPassword() );
        }
        if ( ClientEntity.getStatus() != null ) {
            client.status( ClientEntity.getStatus() );
        }

        return client.build();
    }

    @Override
    public ClientEntity fromModelToEntity(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientEntityBuilder clientEntity = ClientEntity.builder();

        clientEntity.person( clientToPersonEntity( client ) );
        if ( client.getPassword() != null ) {
            clientEntity.password( client.getPassword() );
        }
        if ( client.getStatus() != null ) {
            clientEntity.status( client.getStatus() );
        }
        if ( client.getId() != null ) {
            clientEntity.id( client.getId() );
        }

        return clientEntity.build();
    }

    @Override
    public ClientEntity fromModelToEntity(ClientEntity entity, Client client) {
        if ( client == null ) {
            return null;
        }

        if ( entity.getPerson() == null ) {
            entity.setPerson( new PersonEntity() );
        }
        clientToPersonEntity1( client, entity.getPerson() );
        if ( client.getPassword() != null ) {
            entity.setPassword( client.getPassword() );
        }
        if ( client.getStatus() != null ) {
            entity.setStatus( client.getStatus() );
        }
        if ( client.getId() != null ) {
            entity.setId( client.getId() );
        }
        else {
            entity.setId( null );
        }

        return entity;
    }

    private String clientEntityPersonFullName(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }
        PersonEntity person = clientEntity.getPerson();
        if ( person == null ) {
            return null;
        }
        String fullName = person.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }

    private String clientEntityPersonGender(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }
        PersonEntity person = clientEntity.getPerson();
        if ( person == null ) {
            return null;
        }
        String gender = person.getGender();
        if ( gender == null ) {
            return null;
        }
        return gender;
    }

    private Integer clientEntityPersonAge(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }
        PersonEntity person = clientEntity.getPerson();
        if ( person == null ) {
            return null;
        }
        Integer age = person.getAge();
        if ( age == null ) {
            return null;
        }
        return age;
    }

    private String clientEntityPersonIdNumber(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }
        PersonEntity person = clientEntity.getPerson();
        if ( person == null ) {
            return null;
        }
        String idNumber = person.getIdNumber();
        if ( idNumber == null ) {
            return null;
        }
        return idNumber;
    }

    private String clientEntityPersonAddress(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }
        PersonEntity person = clientEntity.getPerson();
        if ( person == null ) {
            return null;
        }
        String address = person.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private String clientEntityPersonPhone(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }
        PersonEntity person = clientEntity.getPerson();
        if ( person == null ) {
            return null;
        }
        String phone = person.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    protected PersonEntity clientToPersonEntity(Client client) {
        if ( client == null ) {
            return null;
        }

        PersonEntityBuilder personEntity = PersonEntity.builder();

        if ( client.getFullName() != null ) {
            personEntity.fullName( client.getFullName() );
        }
        if ( client.getGender() != null ) {
            personEntity.gender( client.getGender() );
        }
        if ( client.getAge() != null ) {
            personEntity.age( client.getAge() );
        }
        if ( client.getIdNumber() != null ) {
            personEntity.idNumber( client.getIdNumber() );
        }
        if ( client.getAddress() != null ) {
            personEntity.address( client.getAddress() );
        }
        if ( client.getPhone() != null ) {
            personEntity.phone( client.getPhone() );
        }

        return personEntity.build();
    }

    protected void clientToPersonEntity1(Client client, PersonEntity mappingTarget) {
        if ( client == null ) {
            return;
        }

        if ( client.getFullName() != null ) {
            mappingTarget.setFullName( client.getFullName() );
        }
        if ( client.getGender() != null ) {
            mappingTarget.setGender( client.getGender() );
        }
        if ( client.getAge() != null ) {
            mappingTarget.setAge( client.getAge() );
        }
        if ( client.getIdNumber() != null ) {
            mappingTarget.setIdNumber( client.getIdNumber() );
        }
        if ( client.getAddress() != null ) {
            mappingTarget.setAddress( client.getAddress() );
        }
        if ( client.getPhone() != null ) {
            mappingTarget.setPhone( client.getPhone() );
        }
    }
}
