public class Instructor extends Person{
    private int officeHours;
    private Subject[] subjects;
    public int getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(int officeHours) {
        this.officeHours = officeHours;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public void displayInfo() {
        System.out.println("Instructor Name" + this.getName());
        System.out.println("Subjects: ");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i].getName());
        }
    }



}
