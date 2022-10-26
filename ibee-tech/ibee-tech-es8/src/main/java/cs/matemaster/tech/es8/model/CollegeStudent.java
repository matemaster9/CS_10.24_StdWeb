package cs.matemaster.tech.es8.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.Year;

/**
 * @author matemaster
 */
@Data
public class CollegeStudent {
    private String studentId;
    private Boolean sex;
    private Year startYear;
    private Year finishYear;
    private LocalDate birthday;
    private String major;
    private String education;
}
