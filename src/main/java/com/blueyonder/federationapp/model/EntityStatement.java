package com.blueyonder.federationapp.model;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class EntityStatement {
    private String iss;
    private String sub;
    private Instant iat;
    private Instant exp;
    private List<String> authorityHints;
    private Map<String, Object> metadata;

    // getters and setters
    public String getIss() { return iss; }
    public void setIss(String iss) { this.iss = iss; }
    public String getSub() { return sub; }
    public void setSub(String sub) { this.sub = sub; }
    public Instant getIat() { return iat; }
    public void setIat(Instant iat) { this.iat = iat; }
    public Instant getExp() { return exp; }
    public void setExp(Instant exp) { this.exp = exp; }
    public List<String> getAuthorityHints() { return authorityHints; }
    public void setAuthorityHints(List<String> authorityHints) { this.authorityHints = authorityHints; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
}
