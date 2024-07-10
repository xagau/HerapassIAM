package ai.genpen.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Membership")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class Membership   {
  private @Valid String lastLogin;
  private @Valid String status;
  private @Valid Integer fkOrganizationId;
  private @Valid Integer memberId;
  private @Valid Integer fkUserId;
  private @Valid Integer id;
  private @Valid String name;
  private @Valid Boolean isActive;
  private @Valid String memberSince;
  private @Valid Integer numLogins;
  private @Valid Integer fkMemberLevelId;

  /**
   * This attribute is a variable named last_login
   **/
  public Membership lastLogin(String lastLogin) {
    this.lastLogin = lastLogin;
    return this;
  }

  
  @ApiModelProperty(example = "01-01-1968", value = "This attribute is a variable named last_login")
  @JsonProperty("last_login")
  public String getLastLogin() {
    return lastLogin;
  }

  @JsonProperty("last_login")
  public void setLastLogin(String lastLogin) {
    this.lastLogin = lastLogin;
  }

  /**
   * This attribute is a variable named status
   **/
  public Membership status(String status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named status")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * minimum: 0
   * maximum: 10000000
   **/
  public Membership fkOrganizationId(Integer fkOrganizationId) {
    this.fkOrganizationId = fkOrganizationId;
    return this;
  }

  
  @ApiModelProperty(example = "435", value = "")
  @JsonProperty("fk_organization_id")
 @Min(0) @Max(10000000)  public Integer getFkOrganizationId() {
    return fkOrganizationId;
  }

  @JsonProperty("fk_organization_id")
  public void setFkOrganizationId(Integer fkOrganizationId) {
    this.fkOrganizationId = fkOrganizationId;
  }

  /**
   * This attribute is a variable named member_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Membership memberId(Integer memberId) {
    this.memberId = memberId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named member_id")
  @JsonProperty("member_id")
 @Min(0) @Max(10000000)  public Integer getMemberId() {
    return memberId;
  }

  @JsonProperty("member_id")
  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  /**
   * This attribute is a variable named fk_user_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Membership fkUserId(Integer fkUserId) {
    this.fkUserId = fkUserId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named fk_user_id")
  @JsonProperty("fk_user_id")
 @Min(0) @Max(10000000)  public Integer getFkUserId() {
    return fkUserId;
  }

  @JsonProperty("fk_user_id")
  public void setFkUserId(Integer fkUserId) {
    this.fkUserId = fkUserId;
  }

  /**
   * This is a GenPen.AI specific attribute
   * minimum: 0
   * maximum: 10000000
   **/
  public Membership id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "12", value = "This is a GenPen.AI specific attribute")
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
  public Membership name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "88", value = "This is a GenPen.AI specific attribute")
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
  public Membership isActive(Boolean isActive) {
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
   * This attribute is a variable named member_since
   **/
  public Membership memberSince(String memberSince) {
    this.memberSince = memberSince;
    return this;
  }

  
  @ApiModelProperty(example = "01-01-1968", value = "This attribute is a variable named member_since")
  @JsonProperty("member_since")
  public String getMemberSince() {
    return memberSince;
  }

  @JsonProperty("member_since")
  public void setMemberSince(String memberSince) {
    this.memberSince = memberSince;
  }

  /**
   * This attribute is a variable named num_logins
   * minimum: 0
   * maximum: 10000000
   **/
  public Membership numLogins(Integer numLogins) {
    this.numLogins = numLogins;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named num_logins")
  @JsonProperty("num_logins")
 @Min(0) @Max(10000000)  public Integer getNumLogins() {
    return numLogins;
  }

  @JsonProperty("num_logins")
  public void setNumLogins(Integer numLogins) {
    this.numLogins = numLogins;
  }

  /**
   * minimum: 0
   * maximum: 10000000
   **/
  public Membership fkMemberLevelId(Integer fkMemberLevelId) {
    this.fkMemberLevelId = fkMemberLevelId;
    return this;
  }

  
  @ApiModelProperty(example = "234", value = "")
  @JsonProperty("fk_member_level_id")
 @Min(0) @Max(10000000)  public Integer getFkMemberLevelId() {
    return fkMemberLevelId;
  }

  @JsonProperty("fk_member_level_id")
  public void setFkMemberLevelId(Integer fkMemberLevelId) {
    this.fkMemberLevelId = fkMemberLevelId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Membership membership = (Membership) o;
    return Objects.equals(this.lastLogin, membership.lastLogin) &&
        Objects.equals(this.status, membership.status) &&
        Objects.equals(this.fkOrganizationId, membership.fkOrganizationId) &&
        Objects.equals(this.memberId, membership.memberId) &&
        Objects.equals(this.fkUserId, membership.fkUserId) &&
        Objects.equals(this.id, membership.id) &&
        Objects.equals(this.name, membership.name) &&
        Objects.equals(this.isActive, membership.isActive) &&
        Objects.equals(this.memberSince, membership.memberSince) &&
        Objects.equals(this.numLogins, membership.numLogins) &&
        Objects.equals(this.fkMemberLevelId, membership.fkMemberLevelId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastLogin, status, fkOrganizationId, memberId, fkUserId, id, name, isActive, memberSince, numLogins, fkMemberLevelId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Membership {\n");
    
    sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    fkOrganizationId: ").append(toIndentedString(fkOrganizationId)).append("\n");
    sb.append("    memberId: ").append(toIndentedString(memberId)).append("\n");
    sb.append("    fkUserId: ").append(toIndentedString(fkUserId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    memberSince: ").append(toIndentedString(memberSince)).append("\n");
    sb.append("    numLogins: ").append(toIndentedString(numLogins)).append("\n");
    sb.append("    fkMemberLevelId: ").append(toIndentedString(fkMemberLevelId)).append("\n");
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

