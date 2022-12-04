package com.mrt.dictionary.Models;

import java.util.List;

public class Definitions {
    String definition = "";
    String example = "";
    List<String> synonyms = null; /* api'de synonym ve antonym leri definitions class'ı içinden çektim*/
    List<String> antonyms = null; /*o yüzden onları da buraya ekledim*/

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
