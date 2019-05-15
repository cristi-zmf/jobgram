package com.cristi.web.incognito.infra.persistence.subject.codecs;

import com.cristi.web.incognito.domain.subject.Title;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;

public class TitleCodec implements Codec<Title> {

    public static final String TITLE_KEY = "title";
    private DocumentCodec codec;

    @Override
    public Title decode(BsonReader bsonReader, DecoderContext decoderContext) {
        var document = codec.decode(bsonReader, decoderContext);
        return new Title(document.getString(TITLE_KEY));
    }

    @Override
    public void encode(BsonWriter bsonWriter, Title title, EncoderContext encoderContext) {
        codec = new DocumentCodec();
        Document document = new Document();
        document.put(TITLE_KEY, title.getValue());
        codec.encode(bsonWriter, document, encoderContext);
    }

    @Override
    public Class<Title> getEncoderClass() {
        return Title.class;
    }
}
