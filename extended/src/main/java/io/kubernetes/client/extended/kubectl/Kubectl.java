/*
Copyright 2020 The Kubernetes Authors.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.kubernetes.client.extended.kubectl;

import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.extended.kubectl.exception.KubectlException;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.Configuration;

/**
 * Kubectl provides a set of helper functions that has the same functionalities as corresponding
 * kubectl commands.
 */
public class Kubectl {

  /**
   * Equivalence for `kubectl cp`.
   *
   * @return the kubectl copy
   */
  public static KubectlCopy copy() {
    return copy(Configuration.getDefaultApiClient());
  }

  /**
   * Equivalence for `kubectl cp`.
   *
   * @param apiClient the api client instance
   * @return the kubectl copy
   */
  public static KubectlCopy copy(ApiClient apiClient) {
    return new KubectlCopy(apiClient);
  }

  /**
   * Equivalence for `kubectl label`.
   *
   * @param <ApiType> the target api type
   * @param apiTypeClass the api type class
   * @return the kubectl label
   */
  public static <ApiType extends KubernetesObject> KubectlLabel<ApiType> label(
      Class<ApiType> apiTypeClass) {
    return label(Configuration.getDefaultApiClient(), apiTypeClass);
  }

  /**
   * Equivalence for `kubectl label`.
   *
   * @param <ApiType> the target api type
   * @param apiClient the api client instance
   * @param apiTypeClass the api type class
   * @return the kubectl label
   */
  public static <ApiType extends KubernetesObject> KubectlLabel<ApiType> label(
      ApiClient apiClient, Class<ApiType> apiTypeClass) {
    return new KubectlLabel<>(apiClient, apiTypeClass);
  }

  /**
   * Equivalence for `kubectl annotate`.
   *
   * @param <ApiType> the target api type
   * @param apiTypeClass the api type class
   * @return the kubectl annotation
   */
  public static <ApiType extends KubernetesObject> KubectlAnnotate<ApiType> annotate(
      Class<ApiType> apiTypeClass) {
    return annotate(Configuration.getDefaultApiClient(), apiTypeClass);
  }

  /**
   * Equivalence for `kubectl annotate`.
   *
   * @param <ApiType> the target api type
   * @param apiClient the api client instance
   * @param apiTypeClass the api type class
   * @return the kubectl annotation
   */
  public static <ApiType extends KubernetesObject> KubectlAnnotate<ApiType> annotate(
      ApiClient apiClient, Class<ApiType> apiTypeClass) {
    return new KubectlAnnotate<>(apiClient, apiTypeClass);
  }

  /**
   * Equivalence for `kubectl version`.
   *
   * @return the kubectl version
   */
  public static KubectlVersion version() {
    return version(Configuration.getDefaultApiClient());
  }

  /**
   * Equivalence for `kubectl version`.
   *
   * @param apiClient the api client instance
   * @return the kubectl version
   */
  public static KubectlVersion version(ApiClient apiClient) {
    return new KubectlVersion(apiClient);
  }

  /*
   * Equivalent for `kubectl scale`
   *
   * @param <ApiType> the target api type
   * @param apiTypeClass the api type class
   * @return the kubectl scale operator
   */
  public static <ApiType extends KubernetesObject> KubectlScale<ApiType> scale(
      Class<ApiType> apiTypeClass) {
    return scale(Configuration.getDefaultApiClient(), apiTypeClass);
  }

  /**
   * Equivalent for `kubectl scale`
   *
   * @param <ApiType> the target api type
   * @param apiClient The api client instance
   * @param apiTypeClass the api type class
   * @return the kubectl scale operator
   */
  public static <ApiType extends KubernetesObject> KubectlScale<ApiType> scale(
      ApiClient apiClient, Class<ApiType> apiTypeClass) {
    return new KubectlScale<>(apiClient, apiTypeClass);
  }

  /**
   * Equivalent for `kubectl exec`
   *
   * @param apiClient The api client instance
   * @return the kubectl exec operator
   */
  public static KubectlExec exec(ApiClient apiClient) {
    return new KubectlExec(apiClient);
  }

  /**
   * Equivalent for `kubectl exec`
   *
   * @return the kubectl exec operator
   */
  public static KubectlExec exec() {
    return exec(Configuration.getDefaultApiClient());
  }

  /**
   * Equivalent for `kubectl log`
   *
   * @param apiClient The api client instance
   * @return the kubectl log operator
   */
  public static KubectlLog log(ApiClient apiClient) {
    return new KubectlLog(apiClient);
  }

  /**
   * Equivalent for `kubectl log`
   *
   * @return the kubectl log operator
   */
  public static KubectlLog log() {
    return log(Configuration.getDefaultApiClient());
  }

  public static KubectlPortForward portforward() {
    return portforward(Configuration.getDefaultApiClient());
  }

  public static KubectlPortForward portforward(ApiClient apiClient) {
    return new KubectlPortForward(apiClient);
  }

  public static KubectlApiResources apiResources() {
    return apiResources(Configuration.getDefaultApiClient());
  }

  public static KubectlApiResources apiResources(ApiClient apiClient) {
    return new KubectlApiResources(apiClient);
  }

  /**
   * Executable executes a kubectl helper.
   *
   * @param <OUTPUT> the type parameter
   */
  public static interface Executable<OUTPUT> {

    /**
     * Run and retrieve the output from the kubectl helpers.
     *
     * @return the output, can be Void
     * @throws KubectlException the kubectl exception
     */
    OUTPUT execute() throws KubectlException;
  }

  abstract static class ResourceBuilder<
      ApiType extends KubernetesObject, T extends ResourceBuilder<ApiType, T>> {
    final ApiClient apiClient;
    final Class<ApiType> apiTypeClass;
    String namespace;
    String name;
    String apiGroup;
    String apiVersion;
    String resourceNamePlural;

    ResourceBuilder(ApiClient client, Class<ApiType> apiTypeClass) {
      this.apiClient = client;
      this.apiTypeClass = apiTypeClass;
    }

    public T name(String name) {
      this.name = name;
      return (T) this;
    }

    public T namespace(String namespace) {
      this.namespace = namespace;
      return (T) this;
    }

    public T apiGroup(String apiGroup) {
      this.apiGroup = apiGroup;
      return (T) this;
    }

    public T apiVersion(String apiVersion) {
      this.apiVersion = apiVersion;
      return (T) this;
    }

    public T resourceNamePlural(String resourceNamePlural) {
      this.resourceNamePlural = resourceNamePlural;
      return (T) this;
    }
  }

  abstract static class ResourceAndContainerBuilder<
          ApiType extends KubernetesObject, T extends ResourceAndContainerBuilder<ApiType, T>>
      extends ResourceBuilder<ApiType, T> {
    String container;

    ResourceAndContainerBuilder(ApiClient client, Class<ApiType> apiTypeClass) {
      super(client, apiTypeClass);
    }

    public T container(String container) {
      this.container = container;
      return (T) this;
    }
  }
}
