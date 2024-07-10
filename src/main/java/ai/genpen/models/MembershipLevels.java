package ai.genpen.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;



@JsonTypeName("MembershipLevels")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class MembershipLevels   {
  private @Valid Integer fkCustomerId;
  private @Valid Double annualFee;
  private @Valid String expiryDate;
  private @Valid Integer fkMerchantId;
  private @Valid Integer accessLevel;
  private @Valid Boolean renewalNoticeSent;
  private @Valid String membershipLevel;
  private @Valid Boolean membershipActive;
  private @Valid Integer id;
  private @Valid Double monthlyFee;
  private @Valid String name;
  private @Valid String eligibleBenefits;

  /**
   * This attribute is a variable named fk_customer_id
   * minimum: 0
   * maximum: 10000000
   **/
  public MembershipLevels fkCustomerId(Integer fkCustomerId) {
    this.fkCustomerId = fkCustomerId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named fk_customer_id")
  @JsonProperty("fk_customer_id")
 @Min(0) @Max(10000000)  public Integer getFkCustomerId() {
    return fkCustomerId;
  }

  @JsonProperty("fk_customer_id")
  public void setFkCustomerId(Integer fkCustomerId) {
    this.fkCustomerId = fkCustomerId;
  }

  /**
   * This attribute is a variable named annual_fee
   **/
  public MembershipLevels annualFee(Double annualFee) {
    this.annualFee = annualFee;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named annual_fee")
  @JsonProperty("annual_fee")
  public Double getAnnualFee() {
    return annualFee;
  }

  @JsonProperty("annual_fee")
  public void setAnnualFee(Double annualFee) {
    this.annualFee = annualFee;
  }

  /**
   * This attribute is a variable named expiry_date
   **/
  public MembershipLevels expiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  
  @ApiModelProperty(example = "01-01-1968", value = "This attribute is a variable named expiry_date")
  @JsonProperty("expiry_date")
  public String getExpiryDate() {
    return expiryDate;
  }

  @JsonProperty("expiry_date")
  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  /**
   * This attribute is a variable named fk_merchant_id
   * minimum: 0
   * maximum: 10000000
   **/
  public MembershipLevels fkMerchantId(Integer fkMerchantId) {
    this.fkMerchantId = fkMerchantId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named fk_merchant_id")
  @JsonProperty("fk_merchant_id")
 @Min(0) @Max(10000000)  public Integer getFkMerchantId() {
    return fkMerchantId;
  }

  @JsonProperty("fk_merchant_id")
  public void setFkMerchantId(Integer fkMerchantId) {
    this.fkMerchantId = fkMerchantId;
  }

  /**
   * This attribute is a variable named access_level
   * minimum: 0
   * maximum: 10000000
   **/
  public MembershipLevels accessLevel(Integer accessLevel) {
    this.accessLevel = accessLevel;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named access_level")
  @JsonProperty("access_level")
 @Min(0) @Max(10000000)  public Integer getAccessLevel() {
    return accessLevel;
  }

  @JsonProperty("access_level")
  public void setAccessLevel(Integer accessLevel) {
    this.accessLevel = accessLevel;
  }

  /**
   * This attribute is a variable named renewal_notice_sent
   **/
  public MembershipLevels renewalNoticeSent(Boolean renewalNoticeSent) {
    this.renewalNoticeSent = renewalNoticeSent;
    return this;
  }

  
  @ApiModelProperty(example = "false", value = "This attribute is a variable named renewal_notice_sent")
  @JsonProperty("renewal_notice_sent")
  public Boolean getRenewalNoticeSent() {
    return renewalNoticeSent;
  }

  @JsonProperty("renewal_notice_sent")
  public void setRenewalNoticeSent(Boolean renewalNoticeSent) {
    this.renewalNoticeSent = renewalNoticeSent;
  }

  /**
   * This attribute is a variable named membership_level
   **/
  public MembershipLevels membershipLevel(String membershipLevel) {
    this.membershipLevel = membershipLevel;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named membership_level")
  @JsonProperty("membership_level")
  public String getMembershipLevel() {
    return membershipLevel;
  }

  @JsonProperty("membership_level")
  public void setMembershipLevel(String membershipLevel) {
    this.membershipLevel = membershipLevel;
  }

  /**
   * This attribute is a variable named membership_active
   **/
  public MembershipLevels membershipActive(Boolean membershipActive) {
    this.membershipActive = membershipActive;
    return this;
  }

  
  @ApiModelProperty(example = "false", value = "This attribute is a variable named membership_active")
  @JsonProperty("membership_active")
  public Boolean getMembershipActive() {
    return membershipActive;
  }

  @JsonProperty("membership_active")
  public void setMembershipActive(Boolean membershipActive) {
    this.membershipActive = membershipActive;
  }

  /**
   * This is a GenPen.AI specific attribute
   * minimum: 0
   * maximum: 10000000
   **/
  public MembershipLevels id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "101", value = "This is a GenPen.AI specific attribute")
  @JsonProperty("id")
 @Min(0) @Max(10000000)  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * This attribute is a variable named monthly_fee
   **/
  public MembershipLevels monthlyFee(Double monthlyFee) {
    this.monthlyFee = monthlyFee;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named monthly_fee")
  @JsonProperty("monthly_fee")
  public Double getMonthlyFee() {
    return monthlyFee;
  }

  @JsonProperty("monthly_fee")
  public void setMonthlyFee(Double monthlyFee) {
    this.monthlyFee = monthlyFee;
  }

  /**
   * This is a GenPen.AI specific attribute
   **/
  public MembershipLevels name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "40", value = "This is a GenPen.AI specific attribute")
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This attribute is a variable named eligible_benefits
   **/
  public MembershipLevels eligibleBenefits(String eligibleBenefits) {
    this.eligibleBenefits = eligibleBenefits;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named eligible_benefits")
  @JsonProperty("eligible_benefits")
  public String getEligibleBenefits() {
    return eligibleBenefits;
  }

  @JsonProperty("eligible_benefits")
  public void setEligibleBenefits(String eligibleBenefits) {
    this.eligibleBenefits = eligibleBenefits;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MembershipLevels membershipLevels = (MembershipLevels) o;
    return Objects.equals(this.fkCustomerId, membershipLevels.fkCustomerId) &&
        Objects.equals(this.annualFee, membershipLevels.annualFee) &&
        Objects.equals(this.expiryDate, membershipLevels.expiryDate) &&
        Objects.equals(this.fkMerchantId, membershipLevels.fkMerchantId) &&
        Objects.equals(this.accessLevel, membershipLevels.accessLevel) &&
        Objects.equals(this.renewalNoticeSent, membershipLevels.renewalNoticeSent) &&
        Objects.equals(this.membershipLevel, membershipLevels.membershipLevel) &&
        Objects.equals(this.membershipActive, membershipLevels.membershipActive) &&
        Objects.equals(this.id, membershipLevels.id) &&
        Objects.equals(this.monthlyFee, membershipLevels.monthlyFee) &&
        Objects.equals(this.name, membershipLevels.name) &&
        Objects.equals(this.eligibleBenefits, membershipLevels.eligibleBenefits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fkCustomerId, annualFee, expiryDate, fkMerchantId, accessLevel, renewalNoticeSent, membershipLevel, membershipActive, id, monthlyFee, name, eligibleBenefits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MembershipLevels {\n");
    
    sb.append("    fkCustomerId: ").append(toIndentedString(fkCustomerId)).append("\n");
    sb.append("    annualFee: ").append(toIndentedString(annualFee)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
    sb.append("    fkMerchantId: ").append(toIndentedString(fkMerchantId)).append("\n");
    sb.append("    accessLevel: ").append(toIndentedString(accessLevel)).append("\n");
    sb.append("    renewalNoticeSent: ").append(toIndentedString(renewalNoticeSent)).append("\n");
    sb.append("    membershipLevel: ").append(toIndentedString(membershipLevel)).append("\n");
    sb.append("    membershipActive: ").append(toIndentedString(membershipActive)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    monthlyFee: ").append(toIndentedString(monthlyFee)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    eligibleBenefits: ").append(toIndentedString(eligibleBenefits)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

