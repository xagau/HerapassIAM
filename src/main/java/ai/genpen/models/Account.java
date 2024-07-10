package ai.genpen.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;



@JsonTypeName("Account")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class Account   {
  private @Valid String startDate = "";
  private @Valid Boolean isPrimary = false;
  private @Valid String accountName = "";
  private @Valid String description = "";
  private @Valid String walletAddress = "";
  private @Valid String createdDate = "";
  private @Valid Integer accountStatus = 0;
  private @Valid Integer id = 0;
  private @Valid String name = "";
  private @Valid String endDate = "";
  private @Valid String currency = "";
  private @Valid Double balance = new Double(0);
  private @Valid Integer dueDay = 0;
  private @Valid Integer fkParentAccount =0;

  /**
   * This attribute is a variable named start_date
   **/
  public Account startDate(String startDate) {
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
   * This attribute is a variable named is_primary
   **/
  public Account isPrimary(Boolean isPrimary) {
    this.isPrimary = isPrimary;
    return this;
  }

  
  @ApiModelProperty(example = "false", value = "This attribute is a variable named is_primary")
  @JsonProperty("is_primary")
  public Boolean getIsPrimary() {
    return isPrimary;
  }

  @JsonProperty("is_primary")
  public void setIsPrimary(Boolean isPrimary) {
    this.isPrimary = isPrimary;
  }

  /**
   * This attribute is a variable named account_name
   **/
  public Account accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named account_name")
  @JsonProperty("account_name")
  public String getAccountName() {
    return accountName;
  }

  @JsonProperty("account_name")
  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }


  @ApiModelProperty(value = "This attribute is a variable named descripton")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  public Account walletAddress(String walletAddress) {
    this.walletAddress = walletAddress;
    return this;
  }

  
  @ApiModelProperty(example = "0xABCETHEREUM", value = "")
  @JsonProperty("wallet_address")
  public String getWalletAddress() {
    return walletAddress;
  }

  @JsonProperty("wallet_address")
  public void setWalletAddress(String walletAddress) {
    this.walletAddress = walletAddress;
  }

  /**
   * This attribute is a variable named created_date
   **/
  public Account createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  
  @ApiModelProperty(example = "01-01-1968", value = "This attribute is a variable named created_date")
  @JsonProperty("created_date")
  public String getCreatedDate() {
    return createdDate;
  }

  @JsonProperty("created_date")
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * This attribute is a variable named account_status
   * minimum: 0
   * maximum: 10000000
   **/
  public Account accountStatus(Integer accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named account_status")
  @JsonProperty("account_status")
 @Min(0) @Max(10000000)  public Integer getAccountStatus() {
    return accountStatus;
  }

  @JsonProperty("account_status")
  public void setAccountStatus(Integer accountStatus) {
    this.accountStatus = accountStatus;
  }

  /**
   * This is a GenPen.AI specific attribute
   * minimum: 0
   * maximum: 10000000
   **/
  public Account id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "15", value = "This is a GenPen.AI specific attribute")
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
  public Account name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "106", value = "This is a GenPen.AI specific attribute")
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This attribute is a variable named end_date
   **/
  public Account endDate(String endDate) {
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
   * This attribute is a variable named currency
   **/
  public Account currency(String currency) {
    this.currency = currency;
    return this;
  }

  
  @ApiModelProperty(value = "This attribute is a variable named currency")
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  @JsonProperty("currency")
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * This attribute is a variable named balance
   **/
  public Account balance(Double balance) {
    this.balance = balance;
    return this;
  }

  
  @ApiModelProperty(example = "0.0", value = "This attribute is a variable named balance")
  @JsonProperty("balance")
  public double getBalance() {
      if( balance == null ){
          balance = Double.valueOf(0);
      }
    return balance;
  }

  @JsonProperty("balance")
  public void setBalance(double balance) {
    this.balance = balance;
  }

  /**
   * This attribute is a variable named due_day
   **/
  public Account dueDay(Integer dueDay) {
    this.dueDay = dueDay;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named due_day")
  @JsonProperty("due_day")
  public Integer getDueDay() {
    return dueDay;
  }

  @JsonProperty("due_day")
  public void setDueDay(Integer dueDay) {
    this.dueDay = dueDay;
  }

  /**
   * This attribute is a variable named fk_parent_account
   * minimum: 0
   * maximum: 10000000
   **/
  public Account fkParentAccount(Integer fkParentAccount) {
    this.fkParentAccount = fkParentAccount;
    return this;
  }

  
  @ApiModelProperty(example = "0", value = "This attribute is a variable named fk_parent_account")
  @JsonProperty("fk_parent_account")
 @Min(0) @Max(10000000)  public Integer getFkParentAccount() {
    return fkParentAccount;
  }

  @JsonProperty("fk_parent_account")
  public void setFkParentAccount(Integer fkParentAccount) {
    this.fkParentAccount = fkParentAccount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.startDate, account.startDate) &&
        Objects.equals(this.isPrimary, account.isPrimary) &&
        Objects.equals(this.accountName, account.accountName) &&
        Objects.equals(this.description, account.description) &&
        Objects.equals(this.walletAddress, account.walletAddress) &&
        Objects.equals(this.createdDate, account.createdDate) &&
        Objects.equals(this.accountStatus, account.accountStatus) &&
        Objects.equals(this.id, account.id) &&
        Objects.equals(this.name, account.name) &&
        Objects.equals(this.endDate, account.endDate) &&
        Objects.equals(this.currency, account.currency) &&
        Objects.equals(this.balance, account.balance) &&
        Objects.equals(this.dueDay, account.dueDay) &&
        Objects.equals(this.fkParentAccount, account.fkParentAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, isPrimary, accountName, description, walletAddress, createdDate, accountStatus, id, name, endDate, currency, balance, dueDay, fkParentAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    isPrimary: ").append(toIndentedString(isPrimary)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    descripton: ").append(toIndentedString(description)).append("\n");
    sb.append("    walletAddress: ").append(toIndentedString(walletAddress)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    dueDay: ").append(toIndentedString(dueDay)).append("\n");
    sb.append("    fkParentAccount: ").append(toIndentedString(fkParentAccount)).append("\n");
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

