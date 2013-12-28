package by.vsu.emdsproject.model;


public class Teacher extends Person {

    private String rank;
    private Boolean isChief = false;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
    }

    public Boolean getChief() {
        return isChief;
    }

    public void setChief(Boolean chief) {
        isChief = chief;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
