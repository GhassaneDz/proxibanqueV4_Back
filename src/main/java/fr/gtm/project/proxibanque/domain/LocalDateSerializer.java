package fr.gtm.project.proxibanque.domain;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Classe de parsing pour serializer les dates en Json
 *
 * @author Fabien - Faouzi - Nadir
 *
 */
public class LocalDateSerializer extends StdSerializer<LocalDate> {

	/**
	 * Création d'un numéro de sérialisation
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructeur de sérialisation des dates
	 */
	public LocalDateSerializer() {
		super(LocalDate.class);
	}

	/**
	 * Méthode de sérialisation des dates avec gestion des erreurs IOException et
	 * JsonProcessingException
	 * 
	 * @return la LocalDate sérialisée
	 */
	@Override
	public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider sp)
			throws IOException, JsonProcessingException {
		gen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}
}
