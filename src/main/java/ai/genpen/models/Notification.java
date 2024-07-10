package ai.genpen.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;



@JsonTypeName("Notification")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class Notification   {
  private @Valid Integer fkSenderId = 0;
  private @Valid String readTimestamp = "";
  private @Valid String message = "";
  private @Valid String recipient = "";
  private @Valid Boolean expired = false;
  private @Valid Integer id = 0;
  private @Valid Integer attachment = 0;
  private @Valid Integer priority = 0;
  private @Valid String timestamp ="";
  private @Valid String name = "";
  private @Valid Integer fkConversationId = 0;
  private @Valid String reference = "";
  private @Valid String deliveryMethod = "";
  private @Valid Boolean read = false;

  /**
   * This attribute is a variable named fk_sender_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Notification fkSenderId(Integer fkSenderId) {
    this.fkSenderId = fkSenderId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named fk_sender_id")
  @JsonProperty("fk_sender_id")
 @Min(0) @Max(10000000)  public Integer getFkSenderId() {
    return fkSenderId;
  }

  @JsonProperty("fk_sender_id")
  public void setFkSenderId(Integer fkSenderId) {
    this.fkSenderId = fkSenderId;
  }

  /**
   * This attribute is a variable named read timestamp
   **/
  public Notification readTimestamp(String readTimestamp) {
    this.readTimestamp = readTimestamp;
    return this;
  }

  
  @ApiModelProperty(example = "01-01-1968", value = "This attribute is a variable named read timestamp")
  @JsonProperty("read_timestamp")
  public String getReadTimestamp() {
    return readTimestamp;
  }

  @JsonProperty("read_timestamp")
  public void setReadTimestamp(String readTimestamp) {
    this.readTimestamp = readTimestamp;
  }

  /**
   * This attribute is a variable named message
   **/
  public Notification message(String message) {
    this.message = message;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named message")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * This attribute is a variable named fk_recipient_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Notification fkRecipientId(Integer fkRecipientId) {
    this.recipient = recipient;
    return this;
  }

  
  @ApiModelProperty(example = "Abc", value = "This attribute is a variable named recipient")
  @JsonProperty("recipient")
  public String getRecipient() {
    return recipient;
  }

  @JsonProperty("recipient")
  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  /**
   * This attribute is a variable named expired
   **/
  public Notification expired(Boolean expired) {
    this.expired = expired;
    return this;
  }

  
  @ApiModelProperty(example = "false", value = "This attribute is a variable named expired")
  @JsonProperty("expired")
  public Boolean getExpired() {
    return expired;
  }

  @JsonProperty("expired")
  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  /**
   * This is a GenPen.AI specific attribute
   * minimum: 0
   * maximum: 10000000
   **/
  public Notification id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "23", value = "This is a GenPen.AI specific attribute")
  @JsonProperty("id")
 @Min(0) @Max(10000000)  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * This attribute is a variable named attachment
   * minimum: 0
   * maximum: 10000000
   **/
  public Notification attachment(Integer attachment) {
    this.attachment = attachment;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named attachment")
  @JsonProperty("attachment")
 @Min(0) @Max(10000000)  public Integer getAttachment() {
    return attachment;
  }

  @JsonProperty("attachment")
  public void setAttachment(Integer attachment) {
    this.attachment = attachment;
  }

  /**
   * This attribute is a variable named priority
   * minimum: 0
   * maximum: 10000000
   **/
  public Notification priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named priority")
  @JsonProperty("priority")
 @Min(0) @Max(10000000)  public Integer getPriority() {
    return priority;
  }

  @JsonProperty("priority")
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  /**
   * This attribute is a variable named timestamp
   **/
  public Notification timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  
  @ApiModelProperty(example = "01-01-1968", value = "This attribute is a variable named timestamp")
  @JsonProperty("timestamp")
  public String getTimestamp() {
    return timestamp;
  }

  @JsonProperty("timestamp")
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * This is a GenPen.AI specific attribute
   **/
  public Notification name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "96", value = "This is a GenPen.AI specific attribute")
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This attribute is a variable named fk_conversation_id
   * minimum: 0
   * maximum: 10000000
   **/
  public Notification fkConversationId(Integer fkConversationId) {
    this.fkConversationId = fkConversationId;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named fk_conversation_id")
  @JsonProperty("fk_conversation_id")
 @Min(0) @Max(10000000)  public Integer getFkConversationId() {
    return fkConversationId;
  }

  @JsonProperty("fk_conversation_id")
  public void setFkConversationId(Integer fkConversationId) {
    this.fkConversationId = fkConversationId;
  }

  /**
   * This attribute is a variable named reference
   **/
  public Notification reference(String reference) {
    this.reference = reference;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named reference")
  @JsonProperty("reference")
  public String getReference() {
    return reference;
  }

  @JsonProperty("reference")
  public void setReference(String reference) {
    this.reference = reference;
  }

  /**
   * This attribute is a variable named delivery_method
   **/
  public Notification deliveryMethod(String deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named delivery_method")
  @JsonProperty("delivery_method")
  public String getDeliveryMethod() {
    return deliveryMethod;
  }

  @JsonProperty("delivery_method")
  public void setDeliveryMethod(String deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
  }

  /**
   * This attribute is a variable named read
   **/
  public Notification read(Boolean read) {
    this.read = read;
    return this;
  }

  
  @ApiModelProperty(example = "false", value = "This attribute is a variable named read")
  @JsonProperty("read")
  public Boolean getRead() {
    return read;
  }

  @JsonProperty("read")
  public void setRead(Boolean read) {
    this.read = read;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Notification notification = (Notification) o;
    return Objects.equals(this.fkSenderId, notification.fkSenderId) &&
        Objects.equals(this.readTimestamp, notification.readTimestamp) &&
        Objects.equals(this.message, notification.message) &&
        Objects.equals(this.recipient, notification.recipient) &&
        Objects.equals(this.expired, notification.expired) &&
        Objects.equals(this.id, notification.id) &&
        Objects.equals(this.attachment, notification.attachment) &&
        Objects.equals(this.priority, notification.priority) &&
        Objects.equals(this.timestamp, notification.timestamp) &&
        Objects.equals(this.name, notification.name) &&
        Objects.equals(this.fkConversationId, notification.fkConversationId) &&
        Objects.equals(this.reference, notification.reference) &&
        Objects.equals(this.deliveryMethod, notification.deliveryMethod) &&
        Objects.equals(this.read, notification.read);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fkSenderId, readTimestamp, message, recipient, expired, id, attachment, priority, timestamp, name, fkConversationId, reference, deliveryMethod, read);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notification {\n");
    
    sb.append("    fkSenderId: ").append(toIndentedString(fkSenderId)).append("\n");
    sb.append("    readTimestamp: ").append(toIndentedString(readTimestamp)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fkConversationId: ").append(toIndentedString(fkConversationId)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    deliveryMethod: ").append(toIndentedString(deliveryMethod)).append("\n");
    sb.append("    read: ").append(toIndentedString(read)).append("\n");
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

