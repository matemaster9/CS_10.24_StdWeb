package cs.matemaster.demo.jackson.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class ClubMemberVO {

    private String memberName;

    private String memberId;

    private Boolean memberSex;

    private Integer memberRank;
}
