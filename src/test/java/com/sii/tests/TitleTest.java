package com.sii.tests;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class TitleTest extends TestBase {

    @Test
    void shouldValidateCorrectTitle() {
        //WHEN
        String actualTitle = driver.getTitle();
        //THEN
        assertThat(actualTitle).isEqualTo(System.getProperty("eTitle"));

    }
}
