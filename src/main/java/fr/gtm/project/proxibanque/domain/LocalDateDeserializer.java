package fr.gtm.project.proxibanque.domain;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * Classe de parsing pour déserializer les dates en Json
 *
 * @author Fabien - Faouzi - Nadir
 *
 */
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la désérialisation des dates
	 */
	protected LocalDateDeserializer() {
		super(LocalDate.class);
	}

	/**
	 * Désérialisation des dates en catchant les exceptions IOException et
	 * JsonProcessingException
	 *
	 * @return la LocalDate désérialisée
	 */
	@Override
	public LocalDate deserialize(final JsonParser jp, final DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return LocalDate.parse(jp.readValueAs(String.class));
	}
}
