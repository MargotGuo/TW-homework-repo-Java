package quiz.posMachine;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PosMachine {
  private static final String LINE = System.lineSeparator();
  private static final String SPLIT_LINE = "------------------------------------------------------------";
  private static final ObjectMapper objectMapper = new ObjectMapper();

  private Product[] productList;

  public void readDataSource(Reader reader) throws IOException {
    // TODO: please implement the following method to pass the test
    // <--start
    productList = objectMapper.readValue(reader, Product[].class);
    // --end-->
  }

  public String printReceipt(String barcodeContent) throws IOException {
    // TODO: please implement the following method to pass the test
    // <--start
    if (productList == null) {
      throw new IllegalStateException();
    }

    StringBuilder stringBuilder = new StringBuilder("Receipts" + LINE + SPLIT_LINE + LINE);
    AtomicInteger sumPrice = new AtomicInteger();

    Map<Product, Long> productCountMap = Arrays.stream(parseBarcode(barcodeContent))
        .collect(Collectors.groupingBy(this::getProductById, Collectors.counting()));
    productCountMap.keySet().stream()
        .sorted(Comparator.comparing(Product::getId))
        .forEach(product -> {
          sumPrice.addAndGet((int) (product.getPrice() * productCountMap.get(product)));
          stringBuilder.append(String.format("%-32s%-11s%s%s",
              product.getName(), product.getPrice(), productCountMap.get(product), LINE));
        });

    stringBuilder.append(String.format("%s%sPrice: %s%s", SPLIT_LINE, LINE, sumPrice.get(), LINE));
    return stringBuilder.toString();
    // --end-->
  }

  private String[] parseBarcode(String barcodeContent) throws IOException {
    String idArray = Optional.ofNullable(barcodeContent).orElse("[]");
    return objectMapper.readValue(idArray, String[].class);
  }

  private Product getProductById(String id) {
    Optional<Product> matchedProduct = Arrays.stream(productList)
        .filter(product -> product.getId().equals(id))
        .findFirst();
    return matchedProduct.orElse(null);
  }
}

class Product {
  private String id;
  private String name;
  private Integer price;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (this == obj) return true;
    if (getClass() != obj.getClass()) return false;

    Product other = (Product) obj;

    return Objects.equals(id, other.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}