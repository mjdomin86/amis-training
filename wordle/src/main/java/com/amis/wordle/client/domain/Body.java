package com.amis.wordle.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Body {
    @JsonProperty("Word")
    private String word;
    @JsonProperty("Definition")
    private String definition;
    @JsonProperty("Author")
    private String author;
    @JsonProperty("ErrorMessage")
    private Object errorMessage;
    @JsonProperty("EncodingWebName")
    private String encodingWebName;
    @JsonProperty("WordOrigin")
    private Object wordOrigin;
    @JsonProperty("UrlDefinitionSource")
    private String urlDefinitionSource;
    @JsonProperty("Types")
    private ArrayList<Object> types;
    private Urls urls;
    @JsonProperty("DefinitionMD")
    private String definitionMD;
    @JsonProperty("Related")
    private ArrayList<Object> related;

}
