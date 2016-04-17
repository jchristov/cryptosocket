package com.xeiam.xchange.bitstamp.dto.trade;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test Transaction[] JSON parsing
 */
public class OpenOrdersJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is = OpenOrdersJSONTest.class.getResourceAsStream("/trade/example-openorders.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitstampOrder[] orders = mapper.readValue(is, BitstampOrder[].class);

    assertThat(orders.length).isEqualTo(4);

    // Verify that the example data was unmarshalled correctly
    assertThat(orders[1].getId()).isEqualTo(1262468);
    assertThat(orders[1].getPrice()).isEqualTo(new BigDecimal("12.15"));
    assertThat(orders[1].getAmount()).isEqualTo(new BigDecimal("3.00000000"));

  }
}
