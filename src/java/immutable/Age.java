package immutable;

public class Age {

    private int date;
    private int month;
    private int year;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Age{" +
                "date=" + date +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (null == o || getClass() != o.getClass()) {
            return false;
        }

        if (o == this) {
            return true;
        }

        Age age = (Age) o;
        return this.date == age.getDate() && this.month == age.getMonth() && this.year == age.getYear();
    }
}
