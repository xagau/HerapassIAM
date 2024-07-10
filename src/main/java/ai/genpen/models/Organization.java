package ai.genpen.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;



@JsonTypeName("Organization")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class Organization   {
  private @Valid Boolean status = false;
  private @Valid String startDate = "";
  private @Valid String type = "";
  private @Valid Integer fkOwnerId = 0;
  private @Valid Integer primaryContactId = 0;
  private @Valid Integer id = 0;
  private @Valid Integer locationId = 0;
  private @Valid String name = "";
  private @Valid Boolean isActive = false;
  private @Valid String endDate = "";
  private @Valid Integer fkParentId = 0;
  private @Valid String contact = "";

  /**
   * This attribute is a variable named status
   **/
  public Organization status(Boolean status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(example = "false", value = "This attribute is a variable named status")
  @JsonProperty("status")
  public Boolean getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(Boolean status) {
    this.status = status;
  }

  /**
   * This attribute is a variable named start_date
   **/
  public Organization startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  
  @ApiModelProperty(example = "01-01-1968", value = "This attribute is a variable named start_date")
  @JsonProperty("start_date")
  public String getStartDate() {
    return startDate;
  }

  @JsonProperty("start_date")
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  /**
   * This attribute is a variable named type
   **/
  public Organization type(String type) {
    this.type = type;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named type")
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  /**
   * This attribute is a variable named fk_owner_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Organization fkOwnerId(Integer fkOwnerId) {
    this.fkOwnerId = fkOwnerId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named fk_owner_id")
  @JsonProperty("fk_owner_id")
 @Min(0) @Max(10000000)  public Integer getFkOwnerId() {
    return fkOwnerId;
  }

  @JsonProperty("fk_owner_id")
  public void setFkOwnerId(Integer fkOwnerId) {
    this.fkOwnerId = fkOwnerId;
  }

  /**
   * This attribute is a variable named primary_contact_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Organization primaryContactId(Integer primaryContactId) {
    this.primaryContactId = primaryContactId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named primary_contact_id")
  @JsonProperty("primary_contact_id")
 @Min(0) @Max(10000000)  public Integer getPrimaryContactId() {
    return primaryContactId;
  }

  @JsonProperty("primary_contact_id")
  public void setPrimaryContactId(Integer primaryContactId) {
    this.primaryContactId = primaryContactId;
  }

  /**
   * This is a GenPen.AI specific attribute
   * minimum: 0
   * maximum: 10000000
   **/
  public Organization id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "27", value = "This is a GenPen.AI specific attribute")
  @JsonProperty("id")
 @Min(0) @Max(10000000)  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * This attribute is a variable named location_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Organization locationId(Integer locationId) {
    this.locationId = locationId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named location_id")
  @JsonProperty("location_id")
 @Min(0) @Max(10000000)  public Integer getLocationId() {
    return locationId;
  }

  @JsonProperty("location_id")
  public void setLocationId(Integer locationId) {
    this.locationId = locationId;
  }

  /**
   * This is a GenPen.AI specific attribute
   **/
  public Organization name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "37", value = "This is a GenPen.AI specific attribute")
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
  public Organization isActive(Boolean isActive) {
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
   * This attribute is a variable named end_date
   **/
  public Organization endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  
  @ApiModelProperty(example = "01-01-1968", value = "This attribute is a variable named end_date")
  @JsonProperty("end_date")
  public String getEndDate() {
    return endDate;
  }

  @JsonProperty("end_date")
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  /**
   * This attribute is a variable named fk_parent_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Organization fkParentId(Integer fkParentId) {
    this.fkParentId = fkParentId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named fk_parent_id")
  @JsonProperty("fk_parent_id")
 @Min(0) @Max(10000000)  public Integer getFkParentId() {
    return fkParentId;
  }

  @JsonProperty("fk_parent_id")
  public void setFkParentId(Integer fkParentId) {
    this.fkParentId = fkParentId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organization organization = (Organization) o;
    return Objects.equals(this.status, organization.status) &&
        Objects.equals(this.startDate, organization.startDate) &&
        Objects.equals(this.type, organization.type) &&
        Objects.equals(this.fkOwnerId, organization.fkOwnerId) &&
        Objects.equals(this.primaryContactId, organization.primaryContactId) &&
        Objects.equals(this.id, organization.id) &&
        Objects.equals(this.locationId, organization.locationId) &&
        Objects.equals(this.name, organization.name) &&
        Objects.equals(this.isActive, organization.isActive) &&
        Objects.equals(this.endDate, organization.endDate) &&
        Objects.equals(this.fkParentId, organization.fkParentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, startDate, type, fkOwnerId, primaryContactId, id, locationId, name, isActive, endDate, fkParentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organization {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    fkOwnerId: ").append(toIndentedString(fkOwnerId)).append("\n");
    sb.append("    primaryContactId: ").append(toIndentedString(primaryContactId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    fkParentId: ").append(toIndentedString(fkParentId)).append("\n");
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


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

