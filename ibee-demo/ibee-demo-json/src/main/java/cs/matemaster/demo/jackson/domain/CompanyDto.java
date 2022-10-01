package cs.matemaster.demo.jackson.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author matemaster
 */
@Data
public class CompanyDto {

    @JsonProperty("CompanyName")
    private String name;

    @JsonProperty("CompanyFounder")
    private String founder;

    @JsonProperty("CompanyFoundingTime")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate foundDate;

    @JsonProperty("MarketValue")
    private BigDecimal marketValue;

    @JsonProperty("MainBusiness")
    private String mainBusiness;
}
