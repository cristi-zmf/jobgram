package com.cristi.web.incognito.infra.persistence.subject.codecs;

import com.cristi.web.incognito.domain.subject.Description;
import com.cristi.web.incognito.domain.subject.Title;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;

public class DescriptionCodec implements Codec<Description> {

    public static final String DESCRIPTION_KEY = "description";
    private DocumentCodec codec;

    @Override
    public Description decode(BsonReader bsonReader, DecoderContext decoderContext) {
        var document = codec.decode(bsonReader, decoderContext);
        return new Description(document.getString(DESCRIPTION_KEY));
    }

    @Override
    public void encode(BsonWriter bsonWriter, Description description, EncoderContext encoderContext) {
        codec = new DocumentCodec();
        Document document = new Document();
        document.put(DESCRIPTION_KEY, description.getValue());
        codec.encode(bsonWriter, document, encoderContext);
    }

    @Override
    public Class<Description> getEncoderClass() {
        return Description.class;
    }
}
