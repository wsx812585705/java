/*
 * Kubernetes
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1.8.9
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.kubernetes.client.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.kubernetes.client.models.V1ConfigMapProjection;
import io.kubernetes.client.models.V1DownwardAPIProjection;
import io.kubernetes.client.models.V1SecretProjection;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Projection that may be projected along with other supported volume types
 */
@ApiModel(description = "Projection that may be projected along with other supported volume types")

public class V1VolumeProjection {
  @SerializedName("configMap")
  private V1ConfigMapProjection configMap = null;

  @SerializedName("downwardAPI")
  private V1DownwardAPIProjection downwardAPI = null;

  @SerializedName("secret")
  private V1SecretProjection secret = null;

  public V1VolumeProjection configMap(V1ConfigMapProjection configMap) {
    this.configMap = configMap;
    return this;
  }

   /**
   * information about the configMap data to project
   * @return configMap
  **/
  @ApiModelProperty(value = "information about the configMap data to project")
  public V1ConfigMapProjection getConfigMap() {
    return configMap;
  }

  public void setConfigMap(V1ConfigMapProjection configMap) {
    this.configMap = configMap;
  }

  public V1VolumeProjection downwardAPI(V1DownwardAPIProjection downwardAPI) {
    this.downwardAPI = downwardAPI;
    return this;
  }

   /**
   * information about the downwardAPI data to project
   * @return downwardAPI
  **/
  @ApiModelProperty(value = "information about the downwardAPI data to project")
  public V1DownwardAPIProjection getDownwardAPI() {
    return downwardAPI;
  }

  public void setDownwardAPI(V1DownwardAPIProjection downwardAPI) {
    this.downwardAPI = downwardAPI;
  }

  public V1VolumeProjection secret(V1SecretProjection secret) {
    this.secret = secret;
    return this;
  }

   /**
   * information about the secret data to project
   * @return secret
  **/
  @ApiModelProperty(value = "information about the secret data to project")
  public V1SecretProjection getSecret() {
    return secret;
  }

  public void setSecret(V1SecretProjection secret) {
    this.secret = secret;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1VolumeProjection v1VolumeProjection = (V1VolumeProjection) o;
    return Objects.equals(this.configMap, v1VolumeProjection.configMap) &&
        Objects.equals(this.downwardAPI, v1VolumeProjection.downwardAPI) &&
        Objects.equals(this.secret, v1VolumeProjection.secret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configMap, downwardAPI, secret);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1VolumeProjection {\n");
    
    sb.append("    configMap: ").append(toIndentedString(configMap)).append("\n");
    sb.append("    downwardAPI: ").append(toIndentedString(downwardAPI)).append("\n");
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

