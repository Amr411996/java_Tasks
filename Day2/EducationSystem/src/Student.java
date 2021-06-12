public class Student extends Person{
    private int id;
    private Subject[] subjects;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
    public void displayInfo(){
        System.out.println("Student Name" + this.getName());
        System.out.println("Subjects Grade: ");
        for (int i=0;i<subjects.length;i++){
            System.out.println(subjects[i].getName()+ " : " + subjects[i].getGrade());
        }
    }



}
