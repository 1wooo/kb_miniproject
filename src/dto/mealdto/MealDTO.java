package dto.mealdto;

public class MealDTO {
    private String date;
    private String meal;

    public MealDTO(String date, String meal) {
        this.date = date;
        this.meal = meal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }
}
