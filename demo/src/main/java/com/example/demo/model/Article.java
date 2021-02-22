package com.example.demo.model;

public class Article {
}


package com.zetta.ufla.jsonxml.demo.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Article { @SerializedName("id") @Expose private String id; @SerializedName("createdAt") @Expose private String createdAt; @SerializedName("name") @Expose private String name; }17:55