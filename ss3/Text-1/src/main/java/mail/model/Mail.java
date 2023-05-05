package mail.model;

public class Mail {
    private String languages;
    private int pageSize;
    private Boolean spamsFillter;
    private String signature;

    public Mail() {
    }

    public Mail(String languages, int pageSize, Boolean spamsFillter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(Boolean spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
