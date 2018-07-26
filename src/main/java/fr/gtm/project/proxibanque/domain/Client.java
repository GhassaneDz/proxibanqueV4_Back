package fr.gtm.project.proxibanque.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;


/**
 * @author Nadir && Faouzi && Fabien
 * @version 4.0
 * Classe de Client avec en attributs un id, firstName (Prénom), lastName( Nom), tel (téléphone), email et number (identifiant de max 8 chiffres)
 */

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String tel;
	@Column
	private String email;
	@Column
	@Length(max = 8, message = "L'identifiant doit comporter 8 caractères")
	private String number;

	/**
	 * Getter de l'id du Client
	 * @return L'id du client
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter de l'id du Client
	 * @param id du client
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter du firstName du client
	 * @return le firstName du client
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * setter du firstName du client
	 * @param firstName le firstName du client
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter du lastName du client
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter du LastName duc lient
	 * @param lastName du client
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter du téléphone du client
	 * @return tel, le téléphone du client
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * setter du teléphone du client
	 * @param tel le numéro de téléphone du client
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * getter de l'email du client
	 * @return email l'email du client
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setter de l'email du client
	 * @param email l'mail du client
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getter de l'identifiant du client à 8 chiffre
	 * @return number, l'identifiant du client
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * setter de l'identifiant du client
	 * @param number l'identifiant du client
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	
	
	
}
