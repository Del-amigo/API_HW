package POJOs;

public class BankAccounts {
    private String id;
    private String name;
    private String iban;
    private String integrationCode;
    private String schoolId;
    private String currency;
    private boolean deleted;
    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIntegrationCode() {
        return integrationCode;
    }

    public void setIntegrationCode(String integrationCode) {
        this.integrationCode = integrationCode;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "BankAccounts{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iban='" + iban + '\'' +
                ", integrationCode='" + integrationCode + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", currency='" + currency + '\'' +
                ", deleted=" + deleted +
                ", active=" + active +
                '}';
    }
}


