package fr.gtm.project.proxibanque.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

/**
 * @author Nadir && Faouzi && Fabien
 * @version 4.0 Classe de Client avec en attributs un id, firstName (Prénom),
 *          lastName( Nom), tel (téléphone), email et number (identifiant de max
 *          8 chiffres)
 */

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column
	private String email;
	@Column
	private String firstName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String lastName;
	@Column
	@Length(max = 8, message = "L'identifiant doit comporter 8 caractères")
	private String number;
	@Column
	private String tel;

	/**
	 * getter de l'email du client
	 * 
	 * @return email l'email du client
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Getter du firstName du client
	 * 
	 * @return le firstName du client
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Getter de l'id du Client
	 * 
	 * @return L'id du client
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Getter du lastName du client
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * getter de l'identifiant du client à 8 chiffre
	 * 
	 * @return number, l'identifiant du client
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * Getter du téléphone du client
	 * 
	 * @return tel, le téléphone du client
	 */
	public String getTel() {
		return this.tel;
	}

	/**
	 * setter de l'email du client
	 * 
	 * @param email
	 *            l'mail du client
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * setter du firstName du client
	 * 
	 * @param firstName
	 *            le firstName du client
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Setter de l'id du Client
	 * 
	 * @param id
	 *            du client
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Setter du LastName duc lient
	 * 
	 * @param lastName
	 *            du client
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * setter de l'identifiant du client
	 * 
	 * @param number
	 *            l'identifiant du client
	 */
	public void setNumber(final String number) {
		this.number = number;
	}

	/**
	 * setter du teléphone du client
	 * 
	 * @param tel
	 *            le numéro de téléphone du client
	 */
	public void setTel(final String tel) {
		this.tel = tel;
	}

}
