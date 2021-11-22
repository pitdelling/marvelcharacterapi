package br.com.philip.marvelcharacterapi.shared.standard.general;

import java.lang.reflect.Field;

/**
 * class MarvelCharacterApiStandardModel
 *
 * @author philip.delling
 */
public class MarvelCharacterApiStandardClass {

    @Override
    public String toString() {
        try {
            StringBuilder ret = new StringBuilder(getClass().getSimpleName()).append(" = { ");
            boolean isFirstField = true;
            for (Field field : getClass().getDeclaredFields()) {
                field.setAccessible(true);

                if (isFirstField) {
                    isFirstField = false;
                } else {
                    ret.append(", ");
                }

                ret.append(field.getName()).append(": ");
                
                String fieldType = field.getType().toString();
                Object fieldValue = field.get(this);

                if (fieldType.contains("class")) {
                    if (fieldValue == null) {
                        ret.append("null");
                    } else {
                        String fieldTypeSimpleName = field.getType().getSimpleName();
                        switch (fieldTypeSimpleName) {
                            case "Character":
                                ret.append("'").append(fieldValue).append("'");
                                break;
                            case "String":
                                ret.append("\"").append(fieldValue).append("\"");
                                break;
                            case "Integer":
                            case "Long":
                            case "Number":
                            case "Double":
                            case "Float":
                                ret.append(fieldValue);
                                break;
                            default:
                                ret.append(fieldValue.toString());
                                break;
                        }
                    }
                } else {
                    if (fieldType.equalsIgnoreCase("char")) {
                        ret.append("'").append(fieldValue).append("'");
                    } else {
                        ret.append(fieldValue);
                    }

                }

                field.setAccessible(false);
            }

            return ret.append(" }").toString();
        } catch (Exception e) {
            return super.toString();
        }
    }
}
