package StepstoAggregatePartialDatafromMultipleAPICalls;

import java.util.concurrent.CompletableFuture;

public class ApiService {
  public CompletableFuture<String> fetchDataFromApi1() {
    // Simulate API call
    return CompletableFuture.supplyAsync(() -> "Data from API 1");
  }

  public CompletableFuture<String> fetchDataFromApi2() {
    // Simulate API call
    return CompletableFuture.supplyAsync(() -> "Data from API 2");
  }

  public CompletableFuture<String> fetchDataFromApi3() {
    // Simulate API call
    return CompletableFuture.supplyAsync(() -> "Data from API 3");
  }

  public CompletableFuture<String> fetchDataFromApi4() {
    // Simulate API call
    return CompletableFuture.supplyAsync(() -> "Data from API 4");
  }

  public CompletableFuture<String> fetchDataFromApi5() {
    // Simulate API call
    return CompletableFuture.supplyAsync(() -> "Data from API 5");
  }
}
