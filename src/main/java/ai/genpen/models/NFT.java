package ai.genpen.models;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("NFT")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class NFT {
  private @Valid Integer tokenId;
  private @Valid String ipfsHash;
  private @Valid Integer id;
  private @Valid String name;
  private @Valid String contractAddress;

  /**
   * minimum: 0
   * maximum: 10000000
   **/
  public NFT tokenId(Integer tokenId) {
    this.tokenId = tokenId;
    return this;
  }

  
  @ApiModelProperty(example = "45345", value = "")
  @JsonProperty("token_id")
 @Min(0) @Max(10000000)  public Integer getTokenId() {
    return tokenId;
  }

  @JsonProperty("token_id")
  public void setTokenId(Integer tokenId) {
    this.tokenId = tokenId;
  }

  /**
   **/
  public NFT ipfsHash(String ipfsHash) {
    this.ipfsHash = ipfsHash;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("ipfs_hash")
  public String getIpfsHash() {
    return ipfsHash;
  }

  @JsonProperty("ipfs_hash")
  public void setIpfsHash(String ipfsHash) {
    this.ipfsHash = ipfsHash;
  }

  /**
   * id attribute of this model
   * minimum: 0
   * maximum: 10000000
   **/
  public NFT id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "13345", value = "id attribute of this model")
  @JsonProperty("id")
 @Min(0) @Max(10000000)  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * name attribute of this model
   **/
  public NFT name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "A unique name for this model", value = "name attribute of this model")
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public NFT contractAddress(String contractAddress) {
    this.contractAddress = contractAddress;
    return this;
  }

  
  @ApiModelProperty(example = "2748", value = "")
  @JsonProperty("contract_address")
  public String getContractAddress() {
    return contractAddress;
  }

  @JsonProperty("contract_address")
  public void setContractAddress(String contractAddress) {
    this.contractAddress = contractAddress;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NFT nft = (NFT) o;
    return Objects.equals(this.tokenId, nft.tokenId) &&
        Objects.equals(this.ipfsHash, nft.ipfsHash) &&
        Objects.equals(this.id, nft.id) &&
        Objects.equals(this.name, nft.name) &&
        Objects.equals(this.contractAddress, nft.contractAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenId, ipfsHash, id, name, contractAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NFT {\n");
    
    sb.append("    tokenId: ").append(toIndentedString(tokenId)).append("\n");
    sb.append("    ipfsHash: ").append(toIndentedString(ipfsHash)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    contractAddress: ").append(toIndentedString(contractAddress)).append("\n");
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

