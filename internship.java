import java.io.Serializable;

public class Internship implements Serializable {
    private String company;
    private String position;
    private String status;
    private String deadline;
    private String notes;

    public Internship(String company, String position, String status, String deadline, String notes) {
        this.company = company;
        this.position = position;
        this.status = status;
        this.deadline = deadline;
        this.notes = notes;
    }

    public String toString() {
        return "Company: " + company + "\nPosition: " + position + "\nStatus: " + status +
               "\nDeadline: " + deadline + "\nNotes: " + notes + "\n";
    }

    public String toFileString() {
        return company + ";" + position + ";" + status + ";" + deadline + ";" + notes;
    }

    public static Internship fromFileString(String line) {
        String[] parts = line.split(";");
        return new Internship(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}
