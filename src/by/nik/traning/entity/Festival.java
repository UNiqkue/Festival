package by.nik.traning.entity;

public class Festival extends Event {

    private Long id;
    private String description;
    private String date;
    private String place;
    private Integer countUser;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
    }

    @Override
    public void setPlace(String place) {
        super.setPlace(place);
    }

    @Override
    public void setCountUser(Integer countUser) {
        super.setCountUser(countUser);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getDate() {
        return super.getDate();
    }

    @Override
    public String getPlace() {
        return super.getPlace();
    }

    @Override
    public Integer getCountUser() {
        return super.getCountUser();
    }
}
