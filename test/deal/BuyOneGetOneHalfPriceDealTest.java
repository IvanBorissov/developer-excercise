package deal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import product.Product;

public class BuyOneGetOneHalfPriceDealTest {

    private BuyOneGetOneHalfPriceDeal deal;
    private List<Product> productList;

    @BeforeEach
    public void setUp() {
        Product apple = new Product("Apple", 1.00);
        Product banana = new Product("Banana", 0.75);
        Product orange = new Product("Orange", 1.50);
        Product pear = new Product("Pear", 0.90);

        List<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(banana);
        deal = new BuyOneGetOneHalfPriceDeal(products);

        productList = new ArrayList<>();
        productList.add(apple);
        productList.add(apple);
        productList.add(banana);
        productList.add(orange);
        productList.add(pear);
    }

    @Test
    public void testQualifiesForDeal() {
        // Only Apple and Banana are eligible for the deal
        assertTrue(deal.qualifiesForDeal(productList));
    }

    @Test
    public void testCalculateDiscount() {
        // Calculate the discount based on two apples and one banana
        double expectedDiscount = 1.00 * 0.5; // Price of one apple
        assertEquals(expectedDiscount, deal.calculateDiscount(productList));
    }
}
