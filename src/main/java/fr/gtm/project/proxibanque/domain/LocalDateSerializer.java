package fr.gtm.project.proxibanque.domain;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
*
* @author Fabien - Faouzi - Nadir  Classe de parsing pour serializer les dates en Json
*
*/
public class LocalDateSerializer extends StdSerializer<LocalDate> {

    private static final long serialVersionUID = 1L;

    public LocalDateSerializer(){
        super(LocalDate.class);
    }

    @Override
    public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider sp) throws IOException, JsonProcessingException {
        gen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
