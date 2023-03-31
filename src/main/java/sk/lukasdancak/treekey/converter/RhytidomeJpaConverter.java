package sk.lukasdancak.treekey.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import sk.lukasdancak.treekey.enums.Rhytidome;

@Converter
public class RhytidomeJpaConverter implements AttributeConverter<Rhytidome, String> {
    @Override
    public String convertToDatabaseColumn(Rhytidome rhytidome) {
        if (rhytidome == null) {
            return null;
        }
        return rhytidome.toString();
    }

    @Override
    public Rhytidome convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        try {
            return Rhytidome.valueOf(s);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}

