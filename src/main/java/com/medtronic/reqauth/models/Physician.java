package com.medtronic.reqauth.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Physician")
@Table( name = "Physician")
public class Physician {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id")
    private Long id;

    @Column(name = "npi", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String npi;

    @Column(name = "ptan", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String ptan;

    @Column(name = "tin", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String tin;

    @Column(name = "office_contact", nullable = false, columnDefinition = "NVARCHAR(150)")
    private String officeContact;

    @Column(name = "office_phone", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String officePhone;

    @Column(name = "office_email", nullable = false, columnDefinition = "NVARCHAR(100)")
    private String officeEmail;

    @Column(name = "office_fax", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String officeFax;

    // TODO: Practice Attributes 1 to 1 relationship

    //Lombok takes care of empty and full constructors .. this is a partial constructor
    public Physician(String npi, String ptan, String tin, String officeContact, String officePhone, String officeEmail, String officeFax) {
        this.npi = npi;
        this.ptan = ptan;
        this.tin = tin;
        this.officeContact = officeContact;
        this.officePhone = officePhone;
        this.officeEmail = officeEmail;
        this.officeFax = officeFax;
    }

}