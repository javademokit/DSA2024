package StepstoAggregatePartialDatafromMultipleAPICalls;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    ApiService apiService = new ApiService();

    // Make all API calls concurrently
    CompletableFuture<String> api1 = apiService.fetchDataFromApi1();
    CompletableFuture<String> api2 = apiService.fetchDataFromApi2();
    CompletableFuture<String> api3 = apiService.fetchDataFromApi3();
    CompletableFuture<String> api4 = apiService.fetchDataFromApi4();
    CompletableFuture<String> api5 = apiService.fetchDataFromApi5();

    // Combine all futures
    CompletableFuture<List<String>> allOf = CompletableFuture.allOf(api1, api2, api3, api4, api5)
      .thenApply(v -> List.of(api1.join(), api2.join(), api3.join(), api4.join(), api5.join()));

    // Process the aggregated data
    allOf.thenAccept(dataList -> {
      // Example processing: Print the aggregated data
      System.out.println("Aggregated Data: " + dataList);

      // Further processing can be done here
    }).exceptionally(ex -> {
      // Handle exceptions
      System.err.println("An error occurred: " + ex.getMessage());
      return null;
    });
  }
}
