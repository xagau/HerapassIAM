package ai.genpen.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;



@JsonTypeName("Member")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class Member   {
  private @Valid String memberName;
  private @Valid Integer fkSubscriptionId = 0;
  private @Valid Integer contactNumber = 0;
  private @Valid Integer joinedProgramsCount = 0;
  private @Valid String memberEmail = "";
  private @Valid String creationDate = "";
  private @Valid Integer id;
  private @Valid String name = "";
  private @Valid Boolean isActive = false;
  private @Valid String memberCountry = "";
  private @Valid Integer statusType = 0;

  /**
   * This attribute is a variable named member_name
   **/
  public Member memberName(String memberName) {
    this.memberName = memberName;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named member_name")
  @JsonProperty("member_name")
  public String getMemberName() {
    return memberName;
  }

  @JsonProperty("member_name")
  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  /**
   * This attribute is a variable named fk_subscription_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Member fkSubscriptionId(Integer fkSubscriptionId) {
    this.fkSubscriptionId = fkSubscriptionId;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named fk_subscription_id")
  @JsonProperty("fk_subscription_id")
 @Min(0) @Max(10000000)  public Integer getFkSubscriptionId() {
    return fkSubscriptionId;
  }

  @JsonProperty("fk_subscription_id")
  public void setFkSubscriptionId(Integer fkSubscriptionId) {
    this.fkSubscriptionId = fkSubscriptionId;
  }

  /**
   * This attribute is a variable named contact_number
   * minimum: 0
   * maximum: 10000000
   **/
  public Member contactNumber(Integer contactNumber) {
    this.contactNumber = contactNumber;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named contact_number")
  @JsonProperty("contact_number")
 @Min(0) @Max(10000000)  public Integer getContactNumber() {
    return contactNumber;
  }

  @JsonProperty("contact_number")
  public void setContactNumber(Integer contactNumber) {
    this.contactNumber = contactNumber;
  }

  /**
   * This attribute is a variable named joined_programs_count
   * minimum: 0
   * maximum: 10000000
   **/
  public Member joinedProgramsCount(Integer joinedProgramsCount) {
    this.joinedProgramsCount = joinedProgramsCount;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named joined_programs_count")
  @JsonProperty("joined_programs_count")
 @Min(0) @Max(10000000)  public Integer getJoinedProgramsCount() {
    return joinedProgramsCount;
  }

  @JsonProperty("joined_programs_count")
  public void setJoinedProgramsCount(Integer joinedProgramsCount) {
    this.joinedProgramsCount = joinedProgramsCount;
  }

  /**
   * This attribute is a variable named member_email
   **/
  public Member memberEmail(String memberEmail) {
    this.memberEmail = memberEmail;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named member_email")
  @JsonProperty("member_email")
  public String getMemberEmail() {
    return memberEmail;
  }

  @JsonProperty("member_email")
  public void setMemberEmail(String memberEmail) {
    this.memberEmail = memberEmail;
  }

  /**
   * This attribute is a variable named creation_date
   **/
  public Member creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  
  @ApiModelProperty(example = "01-01-1968", value = "This attribute is a variable named creation_date")
  @JsonProperty("creation_date")
  public String getCreationDate() {
    return creationDate;
  }

  @JsonProperty("creation_date")
  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * This is a GenPen.AI specific attribute
   * minimum: 0
   * maximum: 10000000
   **/
  public Member id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "116", value = "This is a GenPen.AI specific attribute")
  @JsonProperty("id")
 @Min(0) @Max(10000000)  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * This is a GenPen.AI specific attribute
   **/
  public Member name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "49", value = "This is a GenPen.AI specific attribute")
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This attribute is a variable named is_active
   **/
  public Member isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  
  @ApiModelProperty(example = "false", value = "This attribute is a variable named is_active")
  @JsonProperty("is_active")
  public Boolean getIsActive() {
    return isActive;
  }

  @JsonProperty("is_active")
  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  /**
   * This attribute is a variable named member_country
   **/
  public Member memberCountry(String memberCountry) {
    this.memberCountry = memberCountry;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named member_country")
  @JsonProperty("member_country")
  public String getMemberCountry() {
    return memberCountry;
  }

  @JsonProperty("member_country")
  public void setMemberCountry(String memberCountry) {
    this.memberCountry = memberCountry;
  }

  /**
   * This attribute is a variable named status_type
   * minimum: 0
   * maximum: 10000000
   **/
  public Member statusType(Integer statusType) {
    this.statusType = statusType;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named status_type")
  @JsonProperty("status_type")
 @Min(0) @Max(10000000)  public Integer getStatusType() {
    return statusType;
  }

  @JsonProperty("status_type")
  public void setStatusType(Integer statusType) {
    this.statusType = statusType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Member member = (Member) o;
    return Objects.equals(this.memberName, member.memberName) &&
        Objects.equals(this.fkSubscriptionId, member.fkSubscriptionId) &&
        Objects.equals(this.contactNumber, member.contactNumber) &&
        Objects.equals(this.joinedProgramsCount, member.joinedProgramsCount) &&
        Objects.equals(this.memberEmail, member.memberEmail) &&
        Objects.equals(this.creationDate, member.creationDate) &&
        Objects.equals(this.id, member.id) &&
        Objects.equals(this.name, member.name) &&
        Objects.equals(this.isActive, member.isActive) &&
        Objects.equals(this.memberCountry, member.memberCountry) &&
        Objects.equals(this.statusType, member.statusType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberName, fkSubscriptionId, contactNumber, joinedProgramsCount, memberEmail, creationDate, id, name, isActive, memberCountry, statusType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Member {\n");
    
    sb.append("    memberName: ").append(toIndentedString(memberName)).append("\n");
    sb.append("    fkSubscriptionId: ").append(toIndentedString(fkSubscriptionId)).append("\n");
    sb.append("    contactNumber: ").append(toIndentedString(contactNumber)).append("\n");
    sb.append("    joinedProgramsCount: ").append(toIndentedString(joinedProgramsCount)).append("\n");
    sb.append("    memberEmail: ").append(toIndentedString(memberEmail)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    memberCountry: ").append(toIndentedString(memberCountry)).append("\n");
    sb.append("    statusType: ").append(toIndentedString(statusType)).append("\n");
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

