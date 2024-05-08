public class Student {
    private String mssv;
    private String fullName;
    private String dateOfBirth;
    private float math;
    private float physics;
    private float chemistry;

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getPhysics() {
        return physics;
    }

    public void setPhysics(float physics) {
        this.physics = physics;
    }

    public float getChemistry() {
        return chemistry;
    }

    public void setChemistry(float chemistry) {
        this.chemistry = chemistry;
    }

    public Student(String mssv, String fullName, String dateOfBirth, float math, float physics, float chemistry) {
        this.mssv = mssv;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }
}
