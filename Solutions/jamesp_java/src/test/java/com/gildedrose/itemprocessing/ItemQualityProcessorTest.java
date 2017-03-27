package com.gildedrose.itemprocessing;

import com.gildedrose.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ItemQualityProcessorTest {

    @Mock
    private UnaryOperator<Item> sellInFunction;
    @Mock
    private UnaryOperator<Item> qualityFunction;
    @Mock
    private Function<Item, Item> composedFunction;
    @Mock
    private Item expectedItem;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void whenUpdatingQuality_sellInAndQualityFunctionsAreInvoked() {
        Item item = new Item("Socks", 14, 40);

        ItemQualityProcessor processor = new ItemQualityProcessor() {
            @Override
            public UnaryOperator<Item> getSellInFunction() {
                return sellInFunction;
            }

            @Override
            public UnaryOperator<Item> getQualityModifierFunction() {
                return qualityFunction;
            }
        };

        when(qualityFunction.andThen(sellInFunction)).thenReturn(composedFunction);
        when(composedFunction.apply(item)).thenReturn(expectedItem);

        Item resultItem = processor.updateQuality(item);

        verify(qualityFunction).andThen(sellInFunction);
        verify(composedFunction).apply(item);
        assertEquals(expectedItem, resultItem);
    }
}