package BTTH3_21521842.B;

import java.io.Serializable;

public class Pupil implements Serializable {
    private static final long serialVersionUID = -8501383434011302991L;

    private String fullName;

    public Pupil(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
